package com.example.nabhiraj.todoapp;
import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
public class Pagev extends AppCompatActivity {
ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagev);
        viewPager=(ViewPager)findViewById(R.id.viewpagerid);
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
         @Override
         public Fragment getItem(int position) {
             Mypager mypager=new Mypager();
             Bundle b=new Bundle();
             b.putInt("ind",position);
             mypager.setArguments(b);
             mypager.setString(Modelcollector.getModelcollector(Pagev.this).getModellist().elementAt(position).getTittle(),Modelcollector.getModelcollector(Pagev.this).getModellist().elementAt(position).getMessage());
             return mypager;
         }
         @Override
         public int getCount() {
             return Modelcollector.getModelcollector(Pagev.this).getModellist().size();
         }
     });
        Intent i=getIntent();
        int a=i.getExtras().getInt("index");
        viewPager.setCurrentItem(a);
    }
}
