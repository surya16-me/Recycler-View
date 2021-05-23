package com.tmd.recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;

public class FruitModel implements Serializable {
    private String fruitName;
    private int imgFruit;
    private String txtFruit;

    public String getTxtFruit() {
        return txtFruit;
    }

    public void setTxtFruit(String txtFruit) {
        this.txtFruit = txtFruit;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getImgFruit() {
        return imgFruit;
    }

    public void setImgFruit(int imgFruit) {
        this.imgFruit = imgFruit;
    }

}
