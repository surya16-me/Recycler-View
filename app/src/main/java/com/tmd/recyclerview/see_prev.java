package com.tmd.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class see_prev extends AppCompatActivity {
    TextView fname;
    ImageView fimage;
    TextView ftext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_prev);
        fname = findViewById(R.id.img_name);
        fimage = findViewById(R.id.img_sec);
        ftext = findViewById(R.id.long_text);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            FruitModel fruitModel = (FruitModel) intent.getSerializableExtra("data");
            fname.setText(fruitModel.getFruitName());
            fimage.setImageResource(fruitModel.getImgFruit());
            ftext.setText(fruitModel.getTxtFruit());
            ftext.setMovementMethod(new ScrollingMovementMethod());
        }
    }
}