package com.example.nabhiraj.todoapp;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by nabhiraj on 10/13/2016.
 */
public class ScrollAdapter extends RecyclerView.Adapter<Onerow> {
   ViewGroup p;
    @Override
    public Onerow onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.onerow_viewholder, parent, false);
        Onerow onerow=new Onerow(view);
        p=parent;
        return onerow;
    }

    @Override
    public void onBindViewHolder(final Onerow holder, final int position) {
      //now we will bind the view holder.
        holder.tittle.setText(Modelcollector.getModelcollector(p.getContext()).getModelatindex(position).getTittle());
        String alpha=Modelcollector.getModelcollector(p.getContext()).getModelatindex(position).getMessage();
        if(alpha.length()>=21) {
            holder.message.setText(alpha.substring(0, 20));
        }else{
            holder.message.setText(alpha);
        }
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(p.getContext(),Pagev.class);
                intent.putExtra("index",position);
                p.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return Modelcollector.special().getModellist().size();
    }
}
