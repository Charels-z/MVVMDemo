package com.mvvm.vm;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.mvvm.databinding.ActivityMvvmLoginBinding;
import com.mvvm.model.UserInfo;

public class LoginViewModel {
    public UserInfo userInfo;
    public LoginViewModel(ActivityMvvmLoginBinding binding) {
        userInfo = new UserInfo();
        // 将ViewModel和View进行绑定，通过DataBinding工具
        binding.setLoginViewModel(this);
    }
    public TextWatcher nameInputListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            userInfo.name.set(String.valueOf(charSequence));
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    public TextWatcher pwdInputListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // View层接收到用户的输入，改变Model层的javabean属性
            userInfo.pwd.set(String.valueOf(s));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public View.OnClickListener loginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 模拟网络请求
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Model层属性的变更，改变View层的显示
                    userInfo.name.set("zjjj");
                    userInfo.pwd.set("654321");

                    if ("xzzz".equals(userInfo.name.get()) && "123456".equals(userInfo.pwd.get())) {
                        Log.e("xzzz >>> ", "登录成功!");
                    } else {
                        Log.e("xzzz >>> ", "登录失败!");
                    }
                }
            }).start();
        }
    };
}
