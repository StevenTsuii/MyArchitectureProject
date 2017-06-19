package com.steventsui.testarchitecture.dagger.module;

import android.app.Fragment;

import com.steventsui.testarchitecture.dagger.scope.FragmentScope;
import com.steventsui.testarchitecture.viewmodel.MainFragmentViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by steven on 19/6/2017.
 */

@Module
public class FragmentModule {

    Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        this.mFragment = fragment;
    }

    @Provides
    @FragmentScope
    Fragment provideFragment() {
        return this.mFragment;
    }

    @Provides
    @FragmentScope
    MainFragmentViewModel provideMainFragmentViewModel() {
        return new MainFragmentViewModel();
    }



}
