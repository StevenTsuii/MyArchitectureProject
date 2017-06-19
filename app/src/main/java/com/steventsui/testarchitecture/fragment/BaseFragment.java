package com.steventsui.testarchitecture.fragment;

import android.app.Fragment;

import com.steventsui.testarchitecture.StevenApplication;
import com.steventsui.testarchitecture.dagger.component.FragmentComponent;

/**
 * Created by steven on 19/6/2017.
 */

public class BaseFragment extends Fragment {

    protected FragmentComponent getFragmentComponent() {
        return ((StevenApplication) getActivity().getApplication()).getFragmentComponent(this);
    }
}
