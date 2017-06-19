package com.steventsui.testarchitecture.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.steventsui.testarchitecture.BR;

/**
 * Created by steven on 19/6/2017.
 */

public class MainFragmentViewModel extends BaseObservable {

    public String title = "Default";

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
}
