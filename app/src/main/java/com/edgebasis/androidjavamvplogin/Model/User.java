package com.edgebasis.androidjavamvplogin.Model;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by mm on 4/24/18.
 */

public class User implements IUser {

    private String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getUser() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {

        if(TextUtils.isEmpty(getUser()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getUser()).matches())
            return 1;
        else if (getPassword().length() <= 6)
            return 2;
        else
            return -1;
    }
}
