package com.steventsui.testarchitecture.dagger.component;

import com.steventsui.testarchitecture.dagger.module.FragmentModule;
import com.steventsui.testarchitecture.dagger.scope.FragmentScope;
import com.steventsui.testarchitecture.fragment.MainFragment;

import dagger.Component;

/**
 * Created by steven on 19/6/2017.
 */

@FragmentScope
@Component(dependencies = {AppComponent.class}, modules = {FragmentModule.class})
public interface FragmentComponent {

    void inject(MainFragment mainFragment);
}
