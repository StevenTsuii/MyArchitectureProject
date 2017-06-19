package com.steventsui.testarchitecture.dagger.component;

import com.steventsui.testarchitecture.activity.MainActivity;
import com.steventsui.testarchitecture.dagger.module.ActivityModule;
import com.steventsui.testarchitecture.dagger.scope.ActivityScope;

import dagger.Component;

/**
 * Created by steven on 19/6/2017.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
