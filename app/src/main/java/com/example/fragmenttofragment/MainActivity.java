package com.example.fragmenttofragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DataPassInterface {

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;
    TextView tvCart;

    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentOne = new FragmentOne();
        fragmentTransaction.replace(R.id.frmButton, fragmentOne);
        fragmentTransaction.commit();


        FragmentManager fragmentManagerSecond = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionSecond = fragmentManagerSecond.beginTransaction();
        fragmentTwo = new FragmentTwo();
        fragmentTransactionSecond.replace(R.id.frmView, fragmentTwo);
        fragmentTransactionSecond.commit();


    }

    private void initializeViews()
    {
        tvCart = findViewById(R.id.tvCart);
    }

    @Override
    public void passData(String data) {

        fragmentTwo.tvDisplayText.setText(data);

        tvCart.setText(data);

        this.data = data;

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data",this.data);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        fragmentTwo.tvDisplayText.setText(savedInstanceState.getString("data"));
        tvCart.setText(savedInstanceState.getString("data"));

        this.data = savedInstanceState.getString("data");
    }
}
