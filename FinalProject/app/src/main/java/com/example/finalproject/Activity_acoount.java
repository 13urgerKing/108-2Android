package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_acoount extends AppCompatActivity {
    private Integer accountbalance=0,monthcount=0;
    private TextView balance,debt,monthspend,ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acoount);
        balance=findViewById(R.id.balance);
        debt=findViewById(R.id.debt);
        monthspend=findViewById(R.id.monthcount);
        ab=findViewById(R.id.accountbalance);
        Intent intent=getIntent();
        accountbalance=intent.getIntExtra("accountbalance",0);
        monthcount=intent.getIntExtra("monthcount",0);
        if(accountbalance<0){
            balance.setText("帳戶資產\n0");
            debt.setText("負債\n"+Integer.toString(Math.abs(accountbalance)));
            ab.setTextColor(Color.parseColor("#FF0000"));
        }
        else{
            balance.setText("帳戶資產\n"+Integer.toString(accountbalance));
            debt.setText("負債\n0");
            ab.setTextColor(Color.parseColor("#00FF00"));
        }
        balance.setTextColor(Color.parseColor("#00FF00"));
        debt.setTextColor(Color.parseColor("#FF0000"));
        monthspend.setText("本月收支\n"+Integer.toString(monthcount));
        monthspend.setTextColor(Color.parseColor("#00FF00"));
        ab.setText(Integer.toString(accountbalance));
        ;
    }
}