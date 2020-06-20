package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_add extends AppCompatActivity {
    private int mode=1,index=0;
    private String yyyy,mm,dd;
    private EditText edit_money,edit_description;
    private LinearLayout linearLayout[]=new LinearLayout[6];
    private TextView textView[]=new TextView[6];
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edit_money=findViewById(R.id.edit_money);
        edit_description=findViewById(R.id.edit_memo);
        linearLayout[0]=findViewById(R.id.LV1);
        linearLayout[1]=findViewById(R.id.LV2);
        linearLayout[2]=findViewById(R.id.LV3);
        linearLayout[3]=findViewById(R.id.LV4);
        linearLayout[4]=findViewById(R.id.LV5);
        linearLayout[5]=findViewById(R.id.LV6);
        textView[0]=findViewById(R.id.text_food);
        textView[1]=findViewById(R.id.text_transport);
        textView[2]=findViewById(R.id.text_fun);
        textView[3]=findViewById(R.id.text_house);
        textView[4]=findViewById(R.id.text_salary);
        textView[5]=findViewById(R.id.text_bonus);
        setColor();
        intent=getIntent();
        yyyy=intent.getStringExtra("yyyy");
        mm=intent.getStringExtra("mm");
        dd=intent.getStringExtra("dd");
        TextView textView=findViewById(R.id.text_date);
        textView.setText(yyyy+"/"+mm+"/"+dd);
    }
    public void cancel(View view){
        this.finish();
        overridePendingTransition(0, 0);
    }
    public void confirm(View view){
        if(edit_money.getText().toString().equals("")){
            Toast.makeText(this,"請輸入金額!!",Toast.LENGTH_SHORT).show();
            return;
        }
        intent.putExtra("modeindex",mode);
        if(mode==0){
            intent.putExtra("mode","收入");
        }
        else{
            intent.putExtra("mode","支出");
        }
        intent.putExtra("money",Integer.parseInt(edit_money.getText().toString()));
        intent.putExtra("description",edit_description.getText().toString());
        intent.putExtra("typeindex",index);
        intent.putExtra("type",textView[index].getText().toString());
        setResult(RESULT_OK,intent);
        this.finish();
        overridePendingTransition(0, 0);
    }
    public void in(View view){
        mode=0;
        TextView textView=findViewById(R.id.in);
        textView.setTextColor(Color.parseColor("#E6E6E6"));
        textView.setBackgroundColor(Color.parseColor("#6200EE"));
        textView=findViewById(R.id.out);
        textView.setTextColor(Color.parseColor("#6200EE"));
        textView.setBackgroundColor(Color.parseColor("#E6E6E6"));
    }
    public void out(View view){
        mode=1;
        TextView textView=findViewById(R.id.out);
        textView.setTextColor(Color.parseColor("#E6E6E6"));
        textView.setBackgroundColor(Color.parseColor("#6200EE"));
        textView=findViewById(R.id.in);
        textView.setTextColor(Color.parseColor("#6200EE"));
        textView.setBackgroundColor(Color.parseColor("#E6E6E6"));

    }
    public void lv1(View view){
        index=0;
        setColor();
    }
    public void lv2(View view){
        index=1;
        setColor();
    }
    public void lv3(View view){
        index=2;
        setColor();
    }
    public void lv4(View view){
        index=3;
        setColor();
    }
    public void lv5(View view){
        index=4;
        setColor();
    }
    public void lv6(View view){
        index=5;
        setColor();
    }
    public void setColor(){
        for(int i=0;i<6;i++){
            if(i==index){
                linearLayout[i].setBackgroundColor(Color.parseColor("#6200EE"));
            }
            else{
                linearLayout[i].setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        }
    }
}