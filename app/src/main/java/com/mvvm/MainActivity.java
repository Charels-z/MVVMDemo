package com.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;

import com.mvvm.databinding.ActivityMvvmLoginBinding;
import com.mvvm.vm.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_login);
        new LoginViewModel(binding);
    }
}
