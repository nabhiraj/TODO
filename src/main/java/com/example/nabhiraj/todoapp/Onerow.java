package com.example.nabhiraj.todoapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by nabhiraj on 10/13/2016.
 */
public class Onerow extends RecyclerView.ViewHolder {
    TextView tittle,message;
    LinearLayout linearLayout;
    public Onerow(View itemView) {
        super(itemView);
        linearLayout=(LinearLayout)itemView.findViewById(R.id.holderid);
        tittle=(TextView)itemView.findViewById(R.id.tittleid);
        message=(TextView)itemView.findViewById(R.id.messageid);
    }
}
