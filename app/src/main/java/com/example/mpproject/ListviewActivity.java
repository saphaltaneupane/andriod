package com.example.mpproject;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView ListView;
    private ProductListAdapter adapter;
    private ArrayList<Product> productlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_view);
        initToolbar();
        findView();
    }

    private void findView(){
        ListView=findViewById(R.id.listview);
        setProductData();
        adapter = new ProductListAdapter(productlist, ListviewActivity.this);
        ListView.setAdapter(adapter);
    }
    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Product List Page");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setProductData(){
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();

        p1.setName("Dew");
        p1.setDescription("green juice");
        p1.setPrice(999);
        p1.setImage(R.drawable.image);

        p2.setName("Fanta");
        p2.setDescription("Orange juice");
        p2.setPrice(999);
        p2.setImage(R.drawable.ic_person);

        p3.setName("Sprite");
        p3.setDescription("White juice");
        p3.setPrice(999);
        p3.setImage(R.drawable.background);

        p4.setName("Coke");
        p4.setDescription("black juice");
        p4.setPrice(999);
        p4.setImage(R.drawable.ic_cart);

        productlist.add(p1);
        productlist.add(p2);
        productlist.add(p3);
        productlist.add(p4);
    }

}