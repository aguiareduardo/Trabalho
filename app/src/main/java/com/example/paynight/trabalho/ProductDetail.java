package com.example.paynight.trabalho;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.paynight.trabalho.MyClass.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDetail extends AppCompatActivity {

    List<Product> Lista;
    TextView tv1;
    TextView tv2;
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);

        Lista = new ArrayList<Product>();
        Lista.add(new Product("unix", "teste"));
        Lista.add(new Product("linux","teste"));
        Lista.add(new Product("windows","teste"));
        Lista.add(new Product("android","teste"));
        Lista.add(new Product("macintosh","teste"));
        Lista.add(new Product("firefox","teste"));
        Lista.add(new Product("facebook","teste"));

        Intent getPar = getIntent();
        Bundle params = getPar.getExtras();

        if (params != null)
        {
            String nome = params.getString("Nome");

            for (Product entity:Lista
                 ) {
                if (entity.getNome().contains(nome))
                {
                    tv1.setText(entity.getNome());
                    tv2.setText(entity.getDetalhe());
                }
            }
        }
    }
}

