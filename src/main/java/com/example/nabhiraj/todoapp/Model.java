package com.example.nabhiraj.todoapp;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by nabhiraj on 10/13/2016.
 */
public class Model implements Serializable {
    private String message=null;
    private String tittle=null;
    public void putMessage(String x){
        message=x;
    }
    public void putTittle(String t){
        tittle=t;
    }
    public String getMessage(){
        return message;
    }
    public String getTittle(){
        return tittle;
    }
}
