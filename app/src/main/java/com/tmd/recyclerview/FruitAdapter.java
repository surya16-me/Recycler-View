package com.tmd.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.Viewholder> {
    private Context context;
    private ArrayList<FruitModel>fruitModels;
    private SelectedFruit selectedFruit;
    String item;
    private static String[] title = new String[]{"Alpukat","Apel","Jeruk","Lemon","Mangga","Nanas","Pear","Pisang","Naga","Manggis"};
    public FruitAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<FruitModel> getFruitModels() {
        return fruitModels;
    }

    public void setFruitModels(ArrayList<FruitModel> fruitModels, SelectedFruit selectedFruit) {
        this.fruitModels = fruitModels;
        this.selectedFruit = selectedFruit;
    }

    @NonNull
    @Override
    public FruitAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buah,parent,false);
        return new Viewholder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.Viewholder holder, int position) {
        Glide.with(context).load(getFruitModels().get(position).getImgFruit()).into(holder.fruitImg);
        holder.fruitName.setText(getFruitModels().get(position).getFruitName());

        item = title[holder.getPosition()];
    }

    @Override
    public int getItemCount() {
        return getFruitModels().size();
    }

    public interface SelectedFruit{
        void selectedFruit(FruitModel fruitModel);
    }
    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView fruitImg;
        private TextView fruitName;
        private Button lihat;
        private Button share;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            fruitImg = itemView.findViewById(R.id.img_fruit);
            fruitName = itemView.findViewById(R.id.fruit_name);
            lihat = itemView.findViewById(R.id.btn_see);
            lihat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedFruit.selectedFruit(fruitModels.get(getBindingAdapterPosition()));

                }
            });

            share = itemView.findViewById(R.id.btn_share);
            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FruitModel fruitModel = new FruitModel();
                    Intent share = new Intent(Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.putExtra(Intent.EXTRA_SUBJECT,"Insert Subject");
                    String appurl = "www.google.com";
                    share.putExtra(Intent.EXTRA_TEXT,appurl);
                    context.startActivity(Intent.createChooser(share," Share " + item));
                }
            });

        }
    }
}
