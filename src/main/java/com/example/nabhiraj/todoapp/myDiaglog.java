package com.example.nabhiraj.todoapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by nabhiraj on 10/14/2016.
 */
public class myDiaglog extends android.support.v4.app.DialogFragment {
    EditText e;
    public Dialog onCreateDialog(Bundle bundle){
        View v= LayoutInflater.from(getActivity()).inflate(R.layout.editmessage,null);
        e=(EditText)v.findViewById(R.id.messageeditlayout);
        e.setText(getArguments().getString("nanu"));

        return new AlertDialog.Builder(getActivity()).setView(v).setTitle("hello").setPositiveButton("save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(getTargetFragment()!=null){
                    Intent i=new Intent();
                    i.putExtra("nanu",e.getText().toString());
                    getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK,i);
                }
            }
        }).setNegativeButton("i do not want to change ", null).create();
    }


}
