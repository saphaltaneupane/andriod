package com.example.mpproject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.PixelCopy;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mpproject.database.DBHandler;
import com.example.mpproject.movie.MovieContainer;
import com.example.mpproject.movie.MovieResults;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ProductRecycleViewActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private ArrayList<Product> productlist = new ArrayList<>();
    ;
    private MovieContainer movieData;
    private DBHandler dbHandler;
    private ArrayList<MovieResults> movieResultList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_recycle_view);
        initToolbar();
        dbHandler= new DBHandler(this);
        JSONAsyncTask jsonAsyncTask = new JSONAsyncTask();
        jsonAsyncTask.execute();
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                findView();
            }
        }, 5000);


    }

    private void findView() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ProductAdapter(movieResultList, ProductRecycleViewActivity.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Recycler Page");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setProductData() {
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

    class JSONAsyncTask extends AsyncTask<Void, Void, Boolean> {
        ProgressDialog progressDialog = new ProgressDialog(ProductRecycleViewActivity.this);

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Please Wait.....");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
            super.onPreExecute();

        }


        @Override
        protected Boolean doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("http://api.themoviedb.org/3/movie/upcoming?api_key=ef8f48b43832a9e95b87408bf739ed51").build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    progressDialog.dismiss();
                    Log.d("Error", String.valueOf(e.getLocalizedMessage()));
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    progressDialog.dismiss();
                    if (response.isSuccessful()) {
                        String jsonObject = response.body().string();
                        Gson gsonObject = new Gson();
                        movieData = gsonObject.fromJson(jsonObject, MovieContainer.class);
                        for(int i=0;i<movieData.getResultList().size();i++){
                            dbHandler.addMovieData(movieData.getResultList().get(i).getOriginalTitle(),movieData.getResultList().get(i).getOverview(),movieData.getResultList().get(i).getReleaseDate(),movieData.getResultList().get(i).getPosterPath());
                        }
                        movieResultList.clear();
                        movieResultList.addAll(movieData.getResultList());


                    }
                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            super.onPostExecute(aBoolean);
        }
    }
}