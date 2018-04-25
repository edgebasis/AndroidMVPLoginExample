package com.edgebasis.androidjavamvplogin.Presenter;

import com.edgebasis.androidjavamvplogin.Model.User;
import com.edgebasis.androidjavamvplogin.View.ILoginView;

/**
 * Created by mm on 4/24/18.
 */

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;


    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode = user.isValidData();

        if(loginCode == 0)
            loginView.onLoginError("You must enter your email");
        else if(loginCode == 1)
            loginView.onLoginError("You must enter a valid email");
        else if(loginCode == 2)
            loginView.onLoginError("Password must be > 6");
        else
            loginView.onLoginSuccess("Login success");
    }
}
