package com.steventsui.testarchitecture.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.steventsui.testarchitecture.model.UserModel;
import com.steventsui.testarchitecture.repository.StevenRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by steven on 26/5/2017.
 */

public class MainActivityViewModel extends ViewModel {

    private static final String TAG = "MainActivityViewModel";
//    private MutableLiveData<List<UserModel>> userModels;
//
//    public MutableLiveData<List<UserModel>> getUserModels() {
//        return userModels;
//    }

    private List<UserModel> userModels;

    public MainActivityViewModel() {
        loadUsers();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    private void loadUsers() {
        StevenRepository.getInstance().getUserModelList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<List<UserModel>>() {
                    @Override
                    public void onNext(List<UserModel> result) {
                        userModels = result;
                        Log.d(TAG, "Loaded userList:" + userModels.size());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
