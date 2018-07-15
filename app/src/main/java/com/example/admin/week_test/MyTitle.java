package com.example.admin.week_test;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MyTitle extends LinearLayout implements View.OnClickListener {
    private ImageView image_sss,image_ss;
    private EditText et_text;
    public MyTitle(Context context) {
        this(context, null);
    }

    public MyTitle(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTitle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        inflate(context, R.layout.mysearchview,this);
        initViews();
        setOnClickListener();
    }

    private void setOnClickListener() {
        image_ss.setOnClickListener(this);
        image_sss.setOnClickListener(this);
    }

    private void initViews() {
        image_ss = findViewById(R.id.image_ss);
        image_sss = findViewById(R.id.image_sss);
        et_text = findViewById(R.id.et_text);
    }
    public String getText(){
        return et_text.getText().toString();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image_ss:
                callback.onSearch(getText());
                break;
            case R.id.image_sss:
                callback.onSearchView(getText());
                break;
        }
    }
    private ViewCallback callback;

    public void setCallback(ViewCallback callback) {
        this.callback = callback;
    }

    public interface ViewCallback{
        void onSearch(String context);

        void onSearchView(String json);
    }
}
