package com.example.nabhiraj.todoapp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nabhiraj on 10/13/2016.
 */
public class Mypager extends Fragment {
    TextView t,m;
    String  st,sm;

    Button editmessage,delete;
    public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup,Bundle bundle){
        View view=inflater.inflate(R.layout.mypager,viewGroup,false);
        t=(TextView)view.findViewById(R.id.innertitleid);
        editmessage=(Button)view.findViewById(R.id.messageedditor);
        m=(TextView)view.findViewById(R.id.innermessageid);
        t.setText(st);
        m.setText(sm);
        editmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                myDiaglog myd = new myDiaglog();
                Bundle bu = new Bundle();
                bu.putString("nanu", m.getText().toString());
                myd.setArguments(bu);
                myd.setTargetFragment(Mypager.this, 10);//10 is the request code.
                myd.show(fragmentManager, "hiha");
            }
        });
        delete = (Button)view.findViewById(R.id.deleteid);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Modelcollector.getModelcollector(getActivity()).getModellist().remove(getArguments().getInt("ind"));
                getActivity().finish();
            }
        });
        return view;
    }
    public void setString(String st,String sm){
    this.st=st;
    this.sm=sm;
}



    public void onActivityResult(int requestcode,int resultcode,Intent intent){
        if(resultcode!= Activity.RESULT_OK){
return;
        }
        if(requestcode==10){
            m.setText(""+(String)intent.getExtras().get("nanu"));
            int i=Modelcollector.getModelcollector(getActivity()).FindPosition(t.getText().toString());
            Modelcollector.getModelcollector(getActivity()).getModellist().elementAt(i).putMessage(""+(String)intent.getExtras().get("nanu"));
        }
    }


}
