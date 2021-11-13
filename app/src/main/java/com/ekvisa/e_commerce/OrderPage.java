package com.ekvisa.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ekvisa.e_commerce.model.Order;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list = findViewById(R.id.orders_list);

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Order.items_id.toArray()));
    }
}