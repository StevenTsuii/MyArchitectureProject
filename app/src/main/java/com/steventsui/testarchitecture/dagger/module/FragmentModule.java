package com.steventsui.testarchitecture.dagger.module;

import android.app.Fragment;
import android.databinding.DataBindingUtil;

import com.steventsui.testarchitecture.R;
import com.steventsui.testarchitecture.dagger.scope.FragmentScope;
import com.steventsui.testarchitecture.databinding.FragmentMainBinding;
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

    @Provides
    @FragmentScope
    FragmentMainBinding provideFragmentMainBinding(Fragment fragment) {
        return DataBindingUtil.inflate(fragment.getActivity().getLayoutInflater(), R.layout.fragment_main, null, false);
    }
}
