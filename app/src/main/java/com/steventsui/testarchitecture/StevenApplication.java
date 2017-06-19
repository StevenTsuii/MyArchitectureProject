package com.steventsui.testarchitecture;

import android.app.Application;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.steventsui.testarchitecture.dagger.component.ActivityComponent;
import com.steventsui.testarchitecture.dagger.component.AppComponent;
import com.steventsui.testarchitecture.dagger.component.DaggerActivityComponent;
import com.steventsui.testarchitecture.dagger.component.DaggerAppComponent;
import com.steventsui.testarchitecture.dagger.component.DaggerFragmentComponent;
import com.steventsui.testarchitecture.dagger.component.FragmentComponent;
import com.steventsui.testarchitecture.dagger.module.ActivityModule;
import com.steventsui.testarchitecture.dagger.module.ApplicationModule;
import com.steventsui.testarchitecture.dagger.module.FragmentModule;
import com.steventsui.testarchitecture.dagger.module.NetModule;

/**
 * Created by steven on 19/6/2017.
 */

public class StevenApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder().applicationModule(new ApplicationModule(this)).netModule(new NetModule("http://etw-dev.api.nextdigital.com.hk/v1/")).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public ActivityComponent getActivityComponent(FragmentActivity fragmentActivity) {
        return DaggerActivityComponent.builder().appComponent(getAppComponent()).activityModule(new ActivityModule(fragmentActivity)).build();
    }

    public FragmentComponent getFragmentComponent(Fragment fragment) {
        return DaggerFragmentComponent.builder().appComponent(getAppComponent()).fragmentModule(new FragmentModule(fragment)).build();
    }
}
