package com.example.admin.week_test.view;

import com.example.admin.week_test.GoodBean;

public interface Iview {
    void view_onSuccess(GoodBean goodBean);

    void view_onFail(int code);
}
