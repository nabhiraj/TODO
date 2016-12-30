package com.example.nabhiraj.todoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by nabhiraj on 10/13/2016.
 */
public class Scrollfragment extends Fragment {
RecyclerView recyclerView=null;
    EditText tittle,message;
    LinearLayout linearLayout=null;
    Button newbutton,savebutton;
    public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup,Bundle bundle){
        Log.d("nanu", "scrollfragment oncreateview");
        View view=inflater.inflate(R.layout.scrolfragment,viewGroup,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerviewid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Modelcollector.getModelcollector(getActivity());
        recyclerView.setAdapter(new ScrollAdapter());
        Log.d("nanu", "recycler view adapter set");
        newbutton=(Button)view.findViewById(R.id.buttonfornewfield);
        tittle=(EditText)view.findViewById(R.id.addtittle);
        message=(EditText)view.findViewById(R.id.addmessage);
        savebutton=(Button)view.findViewById(R.id.sendbutton);
        linearLayout=(LinearLayout)view.findViewById(R.id.llscrolfragment);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message.setVisibility(View.GONE);
                tittle.setVisibility(View.GONE);
                savebutton.setVisibility(View.GONE);
            }
        });
        savebutton.setText("save");

        newbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message.setVisibility(View.VISIBLE);
                tittle.setVisibility(View.VISIBLE);
                savebutton.setVisibility(View.VISIBLE);
                //recyclerView.setAdapter(new ScrollAdapter());
            }
        });

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model m = new Model();
                m.putMessage(message.getText().toString());
                m.putTittle(tittle.getText().toString());
                Modelcollector.getModelcollector(getActivity()).addtolist(m);

                recyclerView.setAdapter(new ScrollAdapter());

                message.setText("");
                tittle.setText("");
                message.setVisibility(View.GONE);
                tittle.setVisibility(View.GONE);
                savebutton.setVisibility(View.GONE);

            }
        });


        return view;
    }


}
