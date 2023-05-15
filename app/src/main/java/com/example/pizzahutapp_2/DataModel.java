package com.example.pizzahutapp_2;

public class DataModel {

    private String product_name;

    private  int product_img;

    private double product_price;

    public DataModel(String pr_name,double pr_price,int pr_img){
        this.product_name = pr_name;
        this.product_img = pr_img;
        this.product_price = pr_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public int getProduct_img() {
        return product_img;
    }
}
