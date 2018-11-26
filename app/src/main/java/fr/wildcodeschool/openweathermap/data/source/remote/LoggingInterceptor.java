package fr.wildcodeschool.openweathermap.data.source.remote;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.internal.EverythingIsNonNull;

/**
 * @author : giallo_n
 */
public class LoggingInterceptor implements Interceptor {

    private static final String VALUE = "YOUR_API";
    private static final String KEY = "APPID";

    private static LoggingInterceptor INSTANCE;

    private LoggingInterceptor() {
    }

    public static LoggingInterceptor getInstance() {
        if (INSTANCE == null)
            INSTANCE = new LoggingInterceptor();
        return INSTANCE;
    }

    @Override
    @EverythingIsNonNull
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url()
                .newBuilder()
                .addQueryParameter(KEY, VALUE)
                .build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
