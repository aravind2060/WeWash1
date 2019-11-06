package com.example.wewash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wewash.MyOrders.A_DisplayMyProducts;
import com.example.wewash.MyOrders.A_InsertMyOrders;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     findViewById(R.id.InsertMyOrder).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(MainActivity.this, A_InsertMyOrders.class));
         }
     });

     findViewById(R.id.Displayproducts).setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(MainActivity.this, A_DisplayMyProducts.class));
         }
     });
    }
}
