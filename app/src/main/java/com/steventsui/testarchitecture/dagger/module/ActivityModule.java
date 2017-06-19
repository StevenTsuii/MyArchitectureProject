package com.steventsui.testarchitecture.dagger.module;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentActivity;

import com.steventsui.testarchitecture.dagger.scope.ActivityScope;
import com.steventsui.testarchitecture.viewmodel.MainActivityViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by steven on 19/6/2017.
 */

@Module
public class ActivityModule {

    FragmentActivity mFragmentActivity;

    public ActivityModule(FragmentActivity fragmentActivity) {
        this.mFragmentActivity = fragmentActivity;
    }


    @ActivityScope
    @Provides
    FragmentActivity provideFragmentActivity() {
        return mFragmentActivity;
    }

    @ActivityScope
    @Provides
    MainActivityViewModel provideMainActivityViewModel(FragmentActivity activity) {
        return ViewModelProviders.of(activity).get(MainActivityViewModel.class);
    }
}
