package com.steventsui.testarchitecture.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.support.annotation.Nullable;
import android.util.Log;

import com.steventsui.testarchitecture.model.UserModel;
import com.steventsui.testarchitecture.repository.StevenRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import livedata.UserModelsLiveData;

/**
 * Created by steven on 26/5/2017.
 */

public class MainActivityViewModel extends ViewModel {

    private static final String TAG = "MainActivityViewModel";
    private LiveData<List<UserModel>> userModelsLiveData;

    public MainActivityViewModel() {
        userModelsLiveData = new UserModelsLiveData();
    }

    public LiveData<List<UserModel>> getUserModelsLiveData() {
        return userModelsLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }


}
