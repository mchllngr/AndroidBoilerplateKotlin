package de.mchllngr.androidboilerplatekotlin.injection;

import javax.inject.Singleton;

import dagger.Component;
import de.mchllngr.androidboilerplatekotlin.module.main.MainPresenter;

/**
 * Dagger2-component for the whole application.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainPresenter presenter);
}
