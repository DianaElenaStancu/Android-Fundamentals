package com.example.androidfall2022.navigation.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.androidfall2022.R;
import com.example.androidfall2022.networking.OnGetUsersCallback;
import com.example.androidfall2022.networking.User;
import com.example.androidfall2022.networking.UsersRepository;

import java.util.List;

public class HomeFragment extends Fragment {


    UsersRepository usersRepository;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //initialize usersRepository

        usersRepository = UsersRepository.getInstance();
        usersRepository.getUsers(new OnGetUsersCallback() {
            @Override
            public void onSuccess(List<User> users) {
                //Recycler View
                Log.e("github users", users.toString());
            }

            @Override
            public void onError() {
                Log.e("Github", "no users");
            }
        });



        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}