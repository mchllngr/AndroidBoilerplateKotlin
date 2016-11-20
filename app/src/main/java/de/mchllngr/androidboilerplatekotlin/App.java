package de.mchllngr.androidboilerplatekotlin;

import android.support.v7.app.AppCompatDelegate;

import de.mchllngr.androidboilerplatekotlin.base.BaseApp;
import de.mchllngr.androidboilerplatekotlin.injection.ApplicationComponent;
import de.mchllngr.androidboilerplatekotlin.injection.ApplicationModule;
import de.mchllngr.androidboilerplatekotlin.injection.DaggerApplicationComponent;

/**
 * {@link App} for the {@link android.app.Application}
 */
public class App extends BaseApp {

    /**
     * Sets the default night mode to follow system.
     */
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
    }

    /**
     * Dagger2-component used for injection.
     */
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }

    /**
     * Gets the Dagger2-component for the whole application.
     *
     * @return Dagger2-component for the whole application
     */
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
