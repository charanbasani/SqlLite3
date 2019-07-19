package com.example.lulloo.sqllite;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
ListView listView;
List<Pojo> pojos;
Button ad,cart;
String str;
SQl_Db my;
SQl_Db1 my1;
    byte[] image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        my = new SQl_Db(this);
        my1 = new SQl_Db1(this);
        listView = findViewById(R.id.list);
        cart = findViewById(R.id.cart);
        ad = findViewById(R.id.ad);
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Main2Activity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        pojos = new ArrayList<>();

        Cursor res = my.gettdata();
        if (res.getCount() == 0) {
            // show message
            // showMessage("Error","Nothing found");
            return;
        }

        // StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {

            image = res.getBlob(3);


            pojos.add(new Pojo(res.getString(0), res.getString(1), res.getString(2), image));


        }
        ListAdapter listAdapter = new ListAdapter(this, pojos);
        listView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

    }


}
