package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_chart extends AppCompatActivity {
    private TextView info,money;
    private int ofood,ifood,otransport,itransport,ofun,ifun,orent,irent,osalary,isalary,obonus,ibonus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        info=findViewById(R.id.txtinfo);
        money=findViewById(R.id.txtmoney);
        ofood=ifood=otransport=itransport=ofun=ifun=orent=irent=osalary=isalary=obonus=ibonus=0;
        Intent intent=getIntent();
        ifood=intent.getIntExtra("ifood",0);
        ofood=intent.getIntExtra("ofood",0);
        itransport=intent.getIntExtra("itransport",0);
        otransport=intent.getIntExtra("otransport",0);
        ifun=intent.getIntExtra("ifun",0);
        ofun=intent.getIntExtra("ofun",0);
        irent=intent.getIntExtra("irent",0);
        orent=intent.getIntExtra("orent",0);
        isalary=intent.getIntExtra("isalary",0);
        osalary=intent.getIntExtra("osalary",0);
        ibonus=intent.getIntExtra("ibonus",0);
        obonus=intent.getIntExtra("obonus",0);
        setoutChart();
    }
    public void in(View view){
        TextView textView=findViewById(R.id.in);
        textView.setTextColor(Color.parseColor("#E6E6E6"));
        textView.setBackgroundColor(Color.parseColor("#6200EE"));
        textView=findViewById(R.id.out);
        textView.setTextColor(Color.parseColor("#6200EE"));
        textView.setBackgroundColor(Color.parseColor("#E6E6E6"));
        setinChart();
    }
    public void out(View view){
        TextView textView=findViewById(R.id.out);
        textView.setTextColor(Color.parseColor("#E6E6E6"));
        textView.setBackgroundColor(Color.parseColor("#6200EE"));
        textView=findViewById(R.id.in);
        textView.setTextColor(Color.parseColor("#6200EE"));
        textView.setBackgroundColor(Color.parseColor("#E6E6E6"));
        setoutChart();
    }
    public void setinChart() {
        info.setText("");
        money.setText("");
        PieChart mchart;
        mchart=(PieChart)findViewById(R.id.chart);
        mchart.clear();
        ArrayList<PieEntry> data = new ArrayList<PieEntry>();
        if(ifood>0){
            data.add(new PieEntry(ifood,"食物"));
            info.setText(info.getText()+"\n食物");
            money.setText(money.getText()+"\n"+Integer.toString(ifood)+"元");
        }
        if(itransport>0){
            data.add(new PieEntry(itransport,"交通"));
            info.setText(info.getText()+"\n交通");
            money.setText(money.getText()+"\n"+Integer.toString(itransport)+"元");
        }
        if(ifun>0){
            data.add(new PieEntry(ifun,"娛樂"));
            info.setText(info.getText()+"\n娛樂");
            money.setText(money.getText()+"\n"+Integer.toString(ifun)+"元");
        }
        if(irent>0){
            data.add(new PieEntry(irent,"房租"));
            info.setText(info.getText()+"\n房租");
            money.setText(money.getText()+"\n"+Integer.toString(irent)+"元");
        }
        if(isalary>0){
            data.add(new PieEntry(isalary,"薪水"));
            info.setText(info.getText()+"\n薪水");
            money.setText(money.getText()+"\n"+Integer.toString(isalary)+"元");
        }
        if(ibonus>0){
            data.add(new PieEntry(ibonus,"紅利"));
            info.setText(info.getText()+"\n紅利");
            money.setText(money.getText()+"\n"+Integer.toString(ibonus)+"元");
        }
        PieDataSet DataSet=new PieDataSet(data,null);
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.RED);
        colors.add(Color.parseColor("#FF8000"));
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.parseColor("#8000FF"));
        DataSet.setValueTextSize(24f);
        DataSet.setColors(colors);
        PieData d = new PieData();
        d.setDataSet(DataSet);
        mchart.getDescription().setText("");
        mchart.setUsePercentValues(true);
        mchart.setEntryLabelTextSize(24f);
        mchart.setEntryLabelColor(Color.parseColor("#000000"));
        mchart.getLegend().setEnabled(false);
        mchart.setDrawHoleEnabled(false);
        mchart.setData(d);
        mchart.invalidate();
    }
    public void setoutChart(){
        info.setText("");
        money.setText("");
        PieChart mchart;
        mchart=(PieChart)findViewById(R.id.chart);
        mchart.clear();
        ArrayList<PieEntry> data = new ArrayList<PieEntry>();
        if(ofood>0){
            data.add(new PieEntry(ofood,"食物"));
            info.setText(info.getText()+"\n食物");
            money.setText(money.getText()+"\n"+Integer.toString(ofood)+"元");
        }
        if(otransport>0){
            data.add(new PieEntry(otransport,"交通"));
            info.setText(info.getText()+"\n交通");
            money.setText(money.getText()+"\n"+Integer.toString(otransport)+"元");
        }
        if(ofun>0){
            data.add(new PieEntry(ofun,"娛樂"));
            info.setText(info.getText()+"\n娛樂");
            money.setText(money.getText()+"\n"+Integer.toString(ofun)+"元");
        }
        if(orent>0){
            data.add(new PieEntry(orent,"房租"));
            info.setText(info.getText()+"\n房租");
            money.setText(money.getText()+"\n"+Integer.toString(orent)+"元");
        }
        if(osalary>0){
            data.add(new PieEntry(osalary,"薪水"));
            info.setText(info.getText()+"\n薪水");
            money.setText(money.getText()+"\n"+Integer.toString(osalary)+"元");
        }
        if(obonus>0){
            data.add(new PieEntry(obonus,"紅利"));
            info.setText(info.getText()+"\n紅利");
            money.setText(money.getText()+"\n"+Integer.toString(obonus)+"元");
        }
        PieDataSet DataSet=new PieDataSet(data,null);
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.RED);
        colors.add(Color.parseColor("#FF8000"));
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.parseColor("#8000FF"));
        DataSet.setValueTextSize(24f);
        DataSet.setColors(colors);
        PieData d = new PieData();
        d.setDataSet(DataSet);
        mchart.getDescription().setText("");
        mchart.setUsePercentValues(true);
        mchart.setEntryLabelTextSize(24f);
        mchart.setEntryLabelColor(Color.parseColor("#000000"));
        mchart.getLegend().setEnabled(false);
        mchart.setDrawHoleEnabled(false);
        mchart.setData(d);
        mchart.invalidate();
    }
}