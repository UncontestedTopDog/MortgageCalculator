package com.example.huangweiliang.mortgagecalculator.selector;

import android.content.Context;


public class SelectorViewBuilder {
    private SelectorOptions selectorOptions;

    public SelectorViewBuilder(Context context) {
        selectorOptions = new SelectorOptions();
        selectorOptions.context = context;
    }

    private SelectorView build(){
        return new SelectorView();
    }
}
