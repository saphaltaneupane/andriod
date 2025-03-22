package com.example.mpproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductVH  extends RecyclerView.ViewHolder {
    ImageView imgProduct;
    TextView txtProductName, txtProductDes,txtProductPrice;
    public ProductVH(@NonNull View view) {
        super(view);
        imgProduct = view.findViewById(R.id.imgProduct);
        txtProductName= view.findViewById(R.id. txtProductName);
        txtProductDes=view.findViewById(R.id.txtProductDes);
        txtProductPrice=view.findViewById(R.id. txtProductPrice);
    }
}
