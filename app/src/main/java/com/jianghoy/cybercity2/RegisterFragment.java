package com.jianghoy.cybercity2;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


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


        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String username = usernameEditText.getText().toString();
                final String password = passwordEditText.getText().toString();

                database.child("user").addListenerForSingleValueEvent(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.hasChild(username)) {
                                    Toast.makeText(getContext(),
                                            "username is already registered",
                                            Toast.LENGTH_LONG).show();
                                } else if (!username.isEmpty() && !password.isEmpty()) {
                                    final User user = new User();
                                    user.setUser_account(username);
                                    user.setUser_password(Utils.md5Encryption(password));
                                    user.setUser_timestamp(System.currentTimeMillis());
                                    database.child("user").child(user.getUser_account()).setValue(user);
                                    Toast.makeText(getContext(),
                                                    "register successfull",
                                                     Toast.LENGTH_LONG);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        }
                );
            }
        });

        return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_register;
    }

}
