package com.example.nabhiraj.todoapp;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Vector;

/**
 * Created by nabhiraj on 10/13/2016.
 */
public class Modelcollector implements Serializable {

    Context c;
    //this is a singleton class.

    //this class containf the list of models which are your bassic storage events which you want to store.
    private Vector<Model> myllist=null;
    static Modelcollector modelcollector=null;

    //creating the private constructor.
    private  Modelcollector(){
        myllist=new Vector<Model>();

    }

    public static Modelcollector getModelcollector(Context c) {
        if (modelcollector == null) {
            try {
                InputStream inputStream = c.openFileInput("todosave.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                modelcollector = (Modelcollector) objectInputStream.readObject();

            } catch (Exception e) {

                //e.printStackTrace();
                modelcollector = new Modelcollector();


            } finally {
                return modelcollector;
            }
        }

        return modelcollector;
    }
public static Modelcollector special(){
    if(modelcollector==null){
        return new Modelcollector();
    }
    return modelcollector;
}
    public void addtolist(Model m){
        myllist.add(m);
    }
    public  Model getModelatindex(int index){
        if(index > myllist.size()){
            return null;
        }
        return myllist.elementAt(index);
    }

    public Vector<Model> getModellist(){
        return myllist;
    }

public int FindPosition(String title){
    for(int i=0;i<myllist.size();i++){
        if(myllist.elementAt(i).getTittle()==title){
            return i;
        }
    }
    return  -1;
}

}
