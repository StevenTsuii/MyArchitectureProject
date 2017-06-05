package com.steventsui.testarchitecture.repository;

import com.steventsui.testarchitecture.datasource.LocalDataSource;
import com.steventsui.testarchitecture.model.UserModel;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

/**
 * Created by steven on 26/5/2017.
 */

public class StevenRepository {
    private static StevenRepository instance;

    public static StevenRepository getInstance() {
        if (instance == null) {
            synchronized (StevenRepository.class) {
                if (instance == null) {
                    instance = new StevenRepository();
                }
            }
        }
        return instance;
    }

    public StevenRepository() {
    }

    public Observable<List<UserModel>> getUserModelList(){
        return Observable.fromCallable(new Callable<List<UserModel>>() {
            @Override
            public List<UserModel> call() throws Exception {
                return LocalDataSource.getUserList();
            }
        });
    }
}
