package com.jianghoy.cybercity2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends OnBoardingBaseFragment {

    public static RegisterFragment newInstance() {
      Bundle args = new Bundle();

      RegisterFragment registerFragment = new RegisterFragment();
      registerFragment.setArguments(args);
      return registerFragment;
    }


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = super.onCreateView(inflater, container, savedInstanceState);
        submitButton.setText(R.string.register);
        return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_register;
    }

}
