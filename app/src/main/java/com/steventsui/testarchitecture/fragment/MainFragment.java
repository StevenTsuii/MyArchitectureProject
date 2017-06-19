package com.steventsui.testarchitecture.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.steventsui.testarchitecture.R;
import com.steventsui.testarchitecture.databinding.FragmentMainBinding;
import com.steventsui.testarchitecture.viewmodel.MainFragmentViewModel;

import javax.inject.Inject;

/**
 * Created by steven on 15/6/2017.
 */

public class MainFragment extends BaseFragment {

    @Inject
    MainFragmentViewModel viewModel;

    FragmentMainBinding binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentComponent().inject(this);
        viewModel.getTitle();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getActivity().getLayoutInflater(), R.layout.fragment_main, null, false);
        return binding.getRoot();
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.setViewModel(viewModel);
        viewModel.setTitle("haha bind");
    }
}
