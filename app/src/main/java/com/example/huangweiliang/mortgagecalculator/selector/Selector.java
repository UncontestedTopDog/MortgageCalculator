package com.example.huangweiliang.mortgagecalculator.selector;

import android.content.Context;
import android.view.View;

public class Selector extends View {

    private OnSelectorCreatedListener onSelectorCreatedListener;

    public void setOnSelectorCreatedListener(OnSelectorCreatedListener onSelectorCreatedListener) {
        this.onSelectorCreatedListener = onSelectorCreatedListener;
    }

    public Selector(Context context) {
        super(context);
        if (onSelectorCreatedListener!=null)
            onSelectorCreatedListener.onSelectorCreated();
    }

    interface OnSelectorCreatedListener{
        void onSelectorCreated();
    }
}
