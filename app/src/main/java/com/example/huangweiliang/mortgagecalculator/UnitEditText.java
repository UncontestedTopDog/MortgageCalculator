package com.example.huangweiliang.mortgagecalculator;import android.content.Context;import android.content.res.TypedArray;import android.support.annotation.Nullable;import android.text.Editable;import android.text.InputType;import android.text.TextWatcher;import android.util.AttributeSet;import android.util.Log;import android.util.TypedValue;import android.view.KeyEvent;import android.view.MotionEvent;import android.view.View;import android.view.inputmethod.EditorInfo;import android.widget.EditText;import android.widget.LinearLayout;import android.widget.RelativeLayout;import android.widget.TextView;public class UnitEditText extends LinearLayout {    private EditText edit ;    private TextView unitText ;    private String unit = "" ;    private String text = "" ;    private IEditTextChangeCallback changeCallback ;    private String id ;    private TextWatcher textWatcher = new TextWatcher() {        @Override        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {        }        @Override        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {            if (changeCallback!=null)            changeCallback.onTextChange(id);        }        @Override        public void afterTextChanged(Editable editable) {            if (changeCallback!=null)                changeCallback.onAfterTextChanged(id);        }    };    public UnitEditText(Context context) {        super(context);        initView(null);    }    public UnitEditText(Context context, @Nullable AttributeSet attrs) {        super(context, attrs);        initView(attrs);    }    public UnitEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {        super(context, attrs, defStyleAttr);        initView(attrs);    }    private void initView(AttributeSet attrs) {        inflate(getContext(),R.layout.unit_edittext_view,this);        if (attrs != null) {            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.UnitEditText);            unit = ta.getString(R.styleable.UnitEditText_unit);            text = ta.getString(R.styleable.UnitEditText_text);            ta.recycle();        }        unitText = findViewById(R.id.unit_text);        unitText.setText(unit);        edit = findViewById(R.id.edit_text);        edit.setCursorVisible(false);        if (text != null)            edit.setText(text);        edit.setOnTouchListener(new OnTouchListener() {            @Override            public boolean onTouch(View view, MotionEvent motionEvent) {                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN){                    edit.getText().clear();                }                return false;            }        });        edit.addTextChangedListener(textWatcher);    }    @Override    protected void onLayout(boolean changed, int l, int t, int r, int b) {        super.onLayout(changed, l, t, r, b);        int left= edit.getPaddingLeft();        int top = edit.getPaddingTop();        int right= unitText.getWidth();        int bottom = edit.getPaddingBottom();        edit.setPadding(left,top,right,bottom);    }    public EditText getEdit() {        return edit;    }    public void setChangeCallback(IEditTextChangeCallback changeCallback , String id) {        this.changeCallback = changeCallback;        this.id = id ;    }}