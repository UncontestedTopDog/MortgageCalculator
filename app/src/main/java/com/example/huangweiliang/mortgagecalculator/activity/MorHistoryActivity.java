package com.example.huangweiliang.mortgagecalculator.activity;import android.os.Bundle;import android.os.SystemClock;import android.support.v7.app.AppCompatActivity;import android.support.v7.widget.LinearLayoutManager;import android.support.v7.widget.RecyclerView;import com.example.huangweiliang.mortgagecalculator.MortgageApp;import com.example.huangweiliang.mortgagecalculator.R;import com.example.huangweiliang.mortgagecalculator.SharedObjects;import com.example.huangweiliang.mortgagecalculator.model.MorHistoryData;import com.example.huangweiliang.mortgagecalculator.view.MorHistoryAdapter;import com.greendao.gen.MorHistoryDataDao;import java.util.ArrayList;import java.util.List;public class MorHistoryActivity extends AppCompatActivity {    private RecyclerView morHistoryList;    private MorHistoryAdapter morHistoryAdapter;    private List<MorHistoryData> morHistoryDatas = new ArrayList<>();    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_mor_history);        MorHistoryDataDao morHistoryDataDao = SharedObjects.INSTANCES.getDaoSession().getMorHistoryDataDao();        morHistoryDatas = morHistoryDataDao.loadAll();        morHistoryList = (RecyclerView) findViewById(R.id.mor_history_list);        morHistoryAdapter = new MorHistoryAdapter();        morHistoryList.setAdapter(morHistoryAdapter);        LinearLayoutManager layoutManager = new LinearLayoutManager(this);        morHistoryList.setLayoutManager(layoutManager);        morHistoryAdapter.setMorHistoryDatas(morHistoryDatas);    }}