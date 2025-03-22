package com.example.mpproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductVH>{
    private ArrayList<Product> productList= new ArrayList<>();
    private Context mContext;
    public ProductAdapter(List<Product> dataList, Context context){
        productList.clear();
        productList.addAll(dataList);
        mContext= context;
    }
    @NonNull
    @Override
    public ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_item, parent,false);
        return new ProductVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductVH holder, int position) {
        holder.txtProductName.setText(productList.get(position).getName());
     holder.txtProductDes.setText(productList.get(position).getDescription());
        holder.txtProductPrice.setText(String.valueOf(productList.get(position).getName()));
        holder.imgProduct.setImageDrawable(mContext.getDrawable(productList.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
