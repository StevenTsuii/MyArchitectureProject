package com.steventsui.testarchitecture.activity;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.steventsui.testarchitecture.R;
import com.steventsui.testarchitecture.fragment.MainFragment;
import com.steventsui.testarchitecture.model.UserModel;
import com.steventsui.testarchitecture.viewmodel.MainActivityViewModel;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MainActivity extends BaseActivity {

    public static final String TAG = "MainActivity";

    //Test for dependency Component. It's not used.
    @Inject
    Retrofit retrofit;

    @Inject
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_main);

        viewModel.getUserModelsLiveData().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(@Nullable List<UserModel> userModels) {
                Log.d("MainActivity", "onChanged userModels.size():" + userModels.size());
            }
        });

        getFragmentManager().beginTransaction().replace(R.id.frame_layout, new MainFragment(), "").commitAllowingStateLoss();
        Log.d(TAG, "BaseUrl: " + retrofit.baseUrl());

    }


}
