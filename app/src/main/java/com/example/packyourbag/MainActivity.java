package com.example.packyourbag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.packyourbag.Adapter.Adapter;
import com.example.packyourbag.constant.MyConstant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    List<String> title;
    List<Integer> images;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.recyclerView);

        addAllimages();
        addAddTitles();

        adapter  = new Adapter(this,images,title,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    // here we understand after double click we exist
    private static final int TIME_INTERVAL = 2000;
    private long mBackpress;

    @Override
    public void onBackPressed(){
        if(mBackpress+TIME_INTERVAL>System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }
        else{
            Toast.makeText(this,"Tap back button in order to exit",Toast.LENGTH_LONG).show();
        }
        mBackpress = System.currentTimeMillis();
    }
    private void addAddTitles(){
        title = new ArrayList<>();
        title.add(MyConstant.BASIC_NEEDS_CAMEL_CASE);
        title.add(MyConstant.CLOTHING_CAMEL_CASE);
        title.add(MyConstant.PERSONAL_CARE_CAMEL_CASE);
        title.add(MyConstant.BABY_NEEDS_CAMEL_CASE);
        title.add(MyConstant.HEALTH_CAMEL_CASE);
        title.add(MyConstant.TECHNOLOGY_CAMEL_CASE);
        title.add(MyConstant.FOOD_CAMEL_CASE);
        title.add(MyConstant.BEACH_SUPPLIES_CAMEL_CASE);
        title.add(MyConstant.CAR_SUPPLIES_CAMEL_CASE);
        title.add(MyConstant.NEEDS_CAMEL_CASE);
        title.add(MyConstant.MY_LIST_CAMEL_CASE);
        title.add(MyConstant.MY_SELECTION_CAMEL_CASE);
    }

    private void addAllimages(){
        images = new ArrayList<>();
        images.add(R.drawable.suitcases);
        images.add(R.drawable.cloth);
        images.add(R.drawable.healthcare);
        images.add(R.drawable.baby);
        images.add(R.drawable.suitcases);
        images.add(R.drawable.technology);
        images.add(R.drawable.food);
        images.add(R.drawable.beach);
        images.add(R.drawable.car);
        images.add(R.drawable.check);
        images.add(R.drawable.mylist);
        images.add(R.drawable.check);
    }
}