package com.steventsui.testarchitecture.activity;

import android.arch.lifecycle.LifecycleActivity;

import com.steventsui.testarchitecture.StevenApplication;
import com.steventsui.testarchitecture.dagger.component.ActivityComponent;

/**
 * Created by steven on 19/6/2017.
 */

public abstract class BaseActivity extends LifecycleActivity {

    protected ActivityComponent getActivityComponent() {
        return ((StevenApplication) getApplication()).getActivityComponent(this);
    }
}
