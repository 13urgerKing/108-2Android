package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler_view;
    private MyAdapter adapter;
    private CalendarView ca;
    private Integer account=0;
    private String yyyy,mm,dd;
    private SimpleDateFormat sdf;
    private Vector v=new Vector();
    public static final int ACTIVITY_ADD=1;
    public class DATA{
        private String y,m,d,mode,type,description;
        private Integer modeindex,typeindex,money;
        public DATA(String year,String month,String day,
                    Integer modeindex, String mode,
                    Integer money,String description,
                    Integer typeindex,String type){
            this.y=year;
            this.m=month;
            this.d=day;
            this.modeindex=modeindex;
            this.mode=mode;
            this.money=money;
            this.description=description;
            this.typeindex=typeindex;
            this.type=type;
        }
        public String getYear() {
            return this.y;
        }
        public String getMonth() {
            return this.m;
        }
        public String getDay() {
            return this.d;
        }
        public Integer getModeIndex() {
            return this.modeindex;
        }
        public String getMode() {
            return this.mode;
        }
        public Integer getMoney() {
            return this.money;
        }
        public String getDescription() {
            return this.description;
        }
        public Integer getTypeIndex() {
            return this.typeindex;
        }
        public String getType() {
            return this.type;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ca=(CalendarView)findViewById(R.id.calendarView);
        sdf = new SimpleDateFormat("yyyy");
        yyyy = sdf.format(new Date(ca.getDate()));
        sdf = new SimpleDateFormat("MM");
        mm = sdf.format(new Date(ca.getDate()));
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        dd = sdf.format(new Date(ca.getDate()));
        ca.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                yyyy=Integer.toString(year);
                if(month+1<10){
                    mm="0"+Integer.toString(month+1);
                }
                else{
                    mm=Integer.toString(month+1);
                }
                if(dayOfMonth<10){
                    dd="0"+Integer.toString(dayOfMonth);
                }
                else{
                    dd=Integer.toString(dayOfMonth);
                }
                showdata();
            }
        });
    }
    public void Add(View view){
        Intent intent=new Intent(this,Activity_add.class);
        intent.putExtra("yyyy",yyyy);
        intent.putExtra("mm",mm);
        intent.putExtra("dd",dd);
        startActivityForResult(intent,ACTIVITY_ADD);
        overridePendingTransition(0, 0);
    }
    public void ShowAccount(View view){
        int monthcount=0;
        for(int i=0;i<v.size();i++){
            DATA d=(DATA)v.get(i);
            if(d.getYear().equals(yyyy)&&d.getMonth().equals(mm)){
                if(d.getModeIndex()==0){
                    monthcount+=d.getMoney();
                }
                else{
                    monthcount-=d.getMoney();
                }
            }
        }
        Intent intent=new Intent(this,Activity_acoount.class);
        intent.putExtra("accountbalance",account);
        intent.putExtra("monthcount",monthcount);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    public void ShowChart(View view){
        int ofood,ifood,otransport,itransport,ofun,ifun,orent,irent,osalary,isalary,obonus,ibonus;
        ofood=ifood=otransport=itransport=ofun=ifun=orent=irent=osalary=isalary=obonus=ibonus=0;
        for(int i=0;i<v.size();i++){
            DATA d=(DATA)v.get(i);
            if(d.getYear().equals(yyyy)&&d.getMonth().equals(mm)){
                if(d.getTypeIndex()==0){
                    if(d.getModeIndex()==0){
                        ifood+=d.getMoney();
                    }
                    else{
                        ofood+=d.getMoney();
                    }
                }
                else if(d.getTypeIndex()==1){
                    if(d.getModeIndex()==0){
                        itransport+=d.getMoney();
                    }
                    else{
                        otransport+=d.getMoney();
                    }
                }
                else if(d.getTypeIndex()==2){
                    if(d.getModeIndex()==0){
                        ifun+=d.getMoney();
                    }
                    else{
                        ofun+=d.getMoney();
                    }
                }
                else if(d.getTypeIndex()==3){
                    if(d.getModeIndex()==0){
                        irent+=d.getMoney();
                    }
                    else{
                        orent+=d.getMoney();
                    }
                }
                else if(d.getTypeIndex()==4){
                    if(d.getModeIndex()==0){
                        isalary+=d.getMoney();
                    }
                    else{
                        osalary+=d.getMoney();
                    }
                }
                else if(d.getTypeIndex()==5){
                    if(d.getModeIndex()==0){
                        ibonus+=d.getMoney();
                    }
                    else{
                        obonus+=d.getMoney();
                    }
                }
            }
        }
        Intent intent=new Intent(this,Activity_chart.class);
        intent.putExtra("ifood",ifood);
        intent.putExtra("ofood",ofood);
        intent.putExtra("itransport",itransport);
        intent.putExtra("otransport",otransport);
        intent.putExtra("ifun",ifun);
        intent.putExtra("ofun",ofun);
        intent.putExtra("irent",irent);
        intent.putExtra("orent",orent);
        intent.putExtra("isalary",isalary);
        intent.putExtra("osalary",osalary);
        intent.putExtra("ibonus",ibonus);
        intent.putExtra("obonus",obonus);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    public void showdata(){
        Vector select=new Vector();
        for(int i=0;i<v.size();i++){
            DATA d=(DATA)v.get(i);
            if(d.getYear().equals(yyyy)&&d.getMonth().equals(mm)&&d.getDay().equals(dd)){
                select.add(d);
            }
        }
        recycler_view = (RecyclerView) findViewById(R.id.recyclerView);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(select);
        recycler_view.setAdapter(adapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ACTIVITY_ADD){
            if(resultCode==RESULT_OK){
                v.add(new DATA(yyyy,mm,dd
                        ,data.getIntExtra("modeindex",0)
                        ,data.getStringExtra("mode")
                        ,data.getIntExtra("money",0)
                        ,data.getStringExtra("description")
                        ,data.getIntExtra("typeindex",0)
                        ,data.getStringExtra("type")));
                showdata();
                DATA d=(DATA)v.get(v.size()-1);
                if(d.getModeIndex()==0){
                    account+=d.getMoney();
                }
                else{
                    account-=d.getMoney();
                }
            }
        }
    }
}
