package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    private TextView tvNombre;
    private TextView tvEdad;
    private TextView tvSigno;
    private TextView tvRfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvEdad = (TextView)findViewById(R.id.tvEdad);
        tvSigno = (TextView)findViewById(R.id.tvSigno);
        tvRfc = (TextView)findViewById(R.id.tvRfc);

        String nombreCompleto = getIntent().getStringExtra("nombre");
        String edad = getIntent().getStringExtra("edad");
        String signo = getIntent().getStringExtra("signo");
        String rfc = getIntent().getStringExtra("rfc");

        tvNombre.setText(nombreCompleto);
        tvEdad.setText(edad);
        tvSigno.setText(signo);
        tvRfc.setText(rfc);
    }

    public void Anterior(View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
        finish();
    }
}
