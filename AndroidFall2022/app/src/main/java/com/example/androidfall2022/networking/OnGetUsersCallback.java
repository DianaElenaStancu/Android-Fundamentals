package com.example.androidfall2022.networking;

import java.util.List;

public interface OnGetUsersCallback {

    // happy path
    void onSuccess(List<User> users);

    // unhappy path
    void onError();
}
