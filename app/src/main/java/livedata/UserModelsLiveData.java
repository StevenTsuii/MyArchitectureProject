package livedata;

import android.arch.lifecycle.LiveData;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;

import com.steventsui.testarchitecture.model.UserModel;
import com.steventsui.testarchitecture.repository.StevenRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by steven on 29/5/2017.
 */

public class UserModelsLiveData extends LiveData<List<UserModel>> {

    private static final String TAG = "UserModelsLiveData";

    @Override
    protected void onActive() {
        super.onActive();
        Log.d("UserModelsLiveData", "onActive");

        StevenRepository.getInstance().getUserModelList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<List<UserModel>>() {
                    @Override
                    public void onNext(List<UserModel> result) {
                        setValue(result);
                        Log.d(TAG, "Loaded userList:" + result.size());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                StevenRepository.getInstance().getUserModelList2()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new DisposableObserver<List<UserModel>>() {
                            @Override
                            public void onNext(List<UserModel> result) {
                                setValue(result);
                                Log.d(TAG, "Loaded userList:" + result.size());
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        }, 3000);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        Log.d("UserModelsLiveData", "onInactive");
    }
}
