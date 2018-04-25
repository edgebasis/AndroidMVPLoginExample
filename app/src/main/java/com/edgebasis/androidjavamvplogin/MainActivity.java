package com.edgebasis.androidjavamvplogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edgebasis.androidjavamvplogin.Presenter.ILoginPresenter;
import com.edgebasis.androidjavamvplogin.Presenter.LoginPresenter;
import com.edgebasis.androidjavamvplogin.View.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText edtEmail, edtPassword;
    Button btnLogin;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(edtEmail.getText().toString(),edtPassword.getText().toString());
            }
        });
    }


    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();


    }
}
