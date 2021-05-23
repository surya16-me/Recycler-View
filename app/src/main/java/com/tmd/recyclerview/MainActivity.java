package com.tmd.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FruitAdapter.SelectedFruit{

    private RecyclerView fruit;
    private ArrayList<FruitModel> listFruit = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fruit = findViewById(R.id.rv_main);
        fruit.setHasFixedSize(true);
        listFruit.addAll(FruitData.getListData());

        showRecyclerList();
    }

    private void showRecyclerList() {
        fruit.setLayoutManager(new LinearLayoutManager(this));
        FruitAdapter fruitAdapter = new FruitAdapter(this);
        fruitAdapter.setFruitModels(listFruit, this);
        fruit.setAdapter(fruitAdapter);
    }

    @Override
    public void selectedFruit(FruitModel fruitModel) {
        startActivity(new Intent(MainActivity.this, see_prev.class).putExtra("data", fruitModel));
    }
}