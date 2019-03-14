package com.example.week5daily3app1.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.week5daily3app1.R;
import com.example.week5daily3app1.controller.CustomBroadcastReceiver;
import com.example.week5daily3app1.model.product.Product;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText productName, productNumber, productCount, productDescription;
    Button button;
    CustomBroadcastReceiver broadcastReceiver;

    public static final String SEND_ACTION = "com.example.week5daily3app1.view.MainActivity";
    private static final String PRODUCT_KEY = "PRODUCT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        productName = findViewById(R.id.productName);
        productNumber = findViewById(R.id.productNumber);
        productCount = findViewById(R.id.productCount);
        productDescription = findViewById(R.id.productDescription);
        button = findViewById(R.id.createBtn);
        button.setOnClickListener(this);
    }

    private boolean isAnViewEmpty() {
        return productName.getText().toString().isEmpty() ||
                productNumber.getText().toString().isEmpty() ||
                productCount.getText().toString().isEmpty() ||
                productDescription.getText().toString().isEmpty();
    }

    @Override
    public void onClick(View v) {

        if (!isAnViewEmpty()) {
            sendInfo();
        } else {
            Toast.makeText(this, "You have to fill all the fields", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendInfo() {
        String name = productName.getText().toString();
        String number = productNumber.getText().toString();
        String count  = productCount.getText().toString();
        String description = productDescription.getText().toString();
//        Product product = new Product(name, number, count, description);

        Bundle bundle = new Bundle();
//        bundle.putParcelable(PRODUCT_KEY, product);
        bundle.putString("name", name);
        bundle.putString("number", number);
        bundle.putString("count", count);
        bundle.putString("description", description);
        Intent intent = new Intent(SEND_ACTION);
        intent.putExtras(bundle);

        Log.d("Log.d", "Product sent");
        sendBroadcast(intent);
    }
}
