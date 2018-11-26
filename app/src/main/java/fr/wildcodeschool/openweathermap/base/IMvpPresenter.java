package fr.wildcodeschool.openweathermap.base;

public interface IMvpPresenter<V extends IMvpView> {
    void attach(V view);

    void detach();
}
