package com.example.admin.week_test.presenter;

import com.example.admin.week_test.GoodBean;
import com.example.admin.week_test.model.Imodel;
import com.example.admin.week_test.model.Show_Model;
import com.example.admin.week_test.view.Iview;

public class Show_Presenter implements Ipresenter {
    private Iview iview;
    private Show_Model show_model;

    public Show_Presenter(Iview iview) {
        this.iview = iview;
        this.show_model = new Show_Model();
    }
    public void getDatas(){
        show_model.getData(new Imodel() {
            @Override
            public void onSuccess(GoodBean goodBean) {
                iview.view_onSuccess(goodBean);
            }

            @Override
            public void onFail(int code) {
                iview.view_onFail(code);
            }
        });
    }

    @Override
    public void onDestroys() {
        if (iview != null){
            iview = null;
        }
    }
}
