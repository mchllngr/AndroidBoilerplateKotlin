package de.mchllngr.androidboilerplatekotlin.module.main;

import de.mchllngr.androidboilerplatekotlin.base.BasePresenter;

/**
 * {@link com.hannesdorfmann.mosby.mvp.MvpPresenter} for the {@link MainActivity}
 */
@SuppressWarnings("ConstantConditions")
public class MainPresenter extends BasePresenter<MainView> {

//    /**
//     * {@link Example}-class for an example for Dagger2-injection.
//     */
//    @Inject
//    Example exampleDependency;

    @Override
    public void attachView(MainView view) {
        super.attachView(view);
        getApplicationComponent().inject(this);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }
}
