package com.example.finalproject;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Vector select;

    MyAdapter(Vector select) {
        this.select=select;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imaget;
        private TextView textt,textd,textn;
        ViewHolder(final View itemView) {
            super(itemView);
            imaget=(ImageView) itemView.findViewById(R.id.imagetype);
            textt = (TextView) itemView.findViewById(R.id.texttype);
            textd = (TextView) itemView.findViewById(R.id.textdescript);
            textn = (TextView) itemView.findViewById(R.id.textnum);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MainActivity.DATA d= (MainActivity.DATA)select.get(position);
        if(d.getTypeIndex()==0){
            holder.imaget.setImageResource(R.drawable.ic_food);
        }
        else if(d.getTypeIndex()==1){
            holder.imaget.setImageResource(R.drawable.ic_bus);
        }
        else if(d.getTypeIndex()==2){
            holder.imaget.setImageResource(R.drawable.ic_tv);
        }
        else if(d.getTypeIndex()==3){
            holder.imaget.setImageResource(R.drawable.ic_house);
        }
        else if(d.getTypeIndex()==4){
            holder.imaget.setImageResource(R.drawable.ic_salary);
        }
        else if(d.getTypeIndex()==5){
            holder.imaget.setImageResource(R.drawable.ic_bonus);
        }
        holder.textt.setText(d.getType());
        holder.textd.setText(d.getDescription());
        holder.textn.setText(d.getMoney().toString());
        if(d.getModeIndex()==0){
            holder.textn.setTextColor(Color.parseColor("#FF0000"));
        }
        else{
            holder.textn.setTextColor(Color.parseColor("#00FF00"));
        }
    }

    @Override
    public int getItemCount() {
        return select.size();
    }
}
