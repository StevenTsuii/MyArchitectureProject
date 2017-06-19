package com.steventsui.testarchitecture.dagger.component;

import com.steventsui.testarchitecture.dagger.module.ApplicationModule;
import com.steventsui.testarchitecture.dagger.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by steven on 19/6/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface AppComponent {

    //void inject(MainActivity activity);

    //Dependency component
    Retrofit retrofit();
}
