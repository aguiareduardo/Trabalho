package com.example.paynight.trabalho;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.paynight.trabalho.MyClass.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Product> Lista;

    String A[] = {"unix","linux","windows","android","macintosh","firefox","google","facebook",};
    Button b;
    ListView lv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Lista = new ArrayList<Product>();
        Lista.add(new Product("unix", ""));
        Lista.add(new Product("linux",""));
        Lista.add(new Product("windows",""));
        Lista.add(new Product("android",""));
        Lista.add(new Product("macintosh",""));
        Lista.add(new Product("firefox",""));
        Lista.add(new Product("facebook",""));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tv = (TextView)findViewById(R.id.textView);
        b = (Button)findViewById(R.id.button01);
        lv = (ListView)findViewById(R.id.listView);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populate();
            }
        });

        lv.setOnItemClickListener(new ListClickHandler());
    }

    public void populate()
    {

        ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(this,android.R.layout.simple_list_item_1, Lista);
        lv.setAdapter(adapter);
    }

    public List<Product> GetProductList()
    {
        List<Product> aux = new ArrayList<Product>();
        String texto = tv.getText().toString();

        for (Product product:Lista)
        {
            if (product.getNome().contains(texto)) {
                aux.add(product);
            }
        }

        return aux;
    }

    public void Onclick(View view)
    {
        populate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class ListClickHandler implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {

            Object o = lv.getItemAtPosition(position);
            String texto = o.toString();
            // TextView listText = (TextView) view.findViewById(R.id.listText);
            // String text = listText.getText().toString();

            // create intent to start another activity
            Intent intent = new Intent(MainActivity.this, ProductDetail.class);
            intent.putExtra("Nome", texto);
            startActivity(intent);
        }
    }
}
