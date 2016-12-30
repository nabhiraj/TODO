package com.example.nabhiraj.todoapp;

import android.content.Intent;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MainActivity extends FragmentActivity {
    Scrollfragment scrollfragment=null;
    FragmentManager fragmentManager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("nanu","oncreate called from mainactivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //lets add fragment

         fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
         scrollfragment=new Scrollfragment();
        if(fragmentManager.findFragmentById(R.id.mainactivityid)==null){
            fragmentTransaction.add(R.id.mainactivityid,scrollfragment);
            fragmentTransaction.commit();
             Log.d("nanu", "scrollfragment called");

        }
    }


    public void onPause(){
        super.onPause();
        try {
        OutputStream outputStream=openFileOutput("todosave.txt",MODE_PRIVATE);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(Modelcollector.getModelcollector(MainActivity.this));
        if(objectOutputStream!=null)
            objectOutputStream.close();
        if(outputStream!=null)
            outputStream.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("nanu", "on start called from mainactivity");
        scrollfragment.recyclerView.setAdapter(new ScrollAdapter());
    }
}
