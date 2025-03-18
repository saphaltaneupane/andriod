package com.example.mpproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class HomeFragment extends Fragment {
    private View mainView;
    private AppCompatButton btnAlert;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       mainView=inflater.inflate(R.layout.fragment_home, container, false);
       findViews();
       return mainView;
    }
    private void findViews(){
  btnAlert=mainView.findViewById(R.id.btnAlert);
  btnAlert.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          showAlertDialog();
      }
  });
    }
    private void showAlertDialog(){
        AlertDialog.Builder builder =new AlertDialog.Builder(getContext());
        builder.setMessage("This is Alert dialog");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"You clicked Okay button",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"You clicked Cancel button",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        AlertDialog dialog= builder.create();
        dialog.show();
    }
}