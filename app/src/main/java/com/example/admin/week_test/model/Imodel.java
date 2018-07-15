package com.example.admin.week_test.model;

import com.example.admin.week_test.GoodBean;

public interface Imodel {
    void onSuccess(GoodBean goodBean);

    void onFail(int code);
}
