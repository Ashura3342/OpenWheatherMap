package fr.wildcodeschool.openweathermap.base;

public class BasePresenter<V extends IMvpView> implements IMvpPresenter<V> {

    private V view;

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
    }

    public V getView() {
        return view;
    }
}
