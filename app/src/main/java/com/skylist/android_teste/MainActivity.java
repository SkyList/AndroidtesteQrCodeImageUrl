package com.skylist.android_teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


//FOR QRCODE WORKS, PLACE YOUR WORDS ON FORMAT BELOW
// nome_pintor;nome_da_obra;url;dd/mm/yyy;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<ModelRecycleView> dataset;
    final Activity activity = this;
    String dadosQR[] = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dataset = new ArrayList< ModelRecycleView >();
        //fillList();

        recyclerView = findViewById(R.id.recycleView);

        updateRecicleView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Scanning...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                scanCode();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult( requestCode, resultCode, data );
        if(result != null){
            if( result.getContents() !=null ){
                Toast.makeText( getApplicationContext(), "Scan success", Toast.LENGTH_SHORT ).show();
                dadosQR = result.getContents().split(";");
                dataset.add(  new ModelRecycleView(  dadosQR ) );
                updateRecicleView();
            }else{
                Toast.makeText( getApplicationContext(), "Scan error", Toast.LENGTH_SHORT ).show();
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }

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


    public void scanCode(){
        IntentIntegrator integrator = new IntentIntegrator( activity );
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Camera Scan");
        integrator.setCameraId(0);
        integrator.initiateScan();
    }

    void updateRecicleView(){
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyAdapter( dataset );
        recyclerView.setAdapter( adapter );
    }
}
