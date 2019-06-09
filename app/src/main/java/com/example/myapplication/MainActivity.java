package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apPat;
    private EditText apMat;
    private EditText fecha;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.etNombre);
        apPat = findViewById(R.id.etApPat);
        apMat = findViewById(R.id.etApMat);
        fecha=findViewById(R.id.etFecha);

        fecha=(EditText) findViewById(R.id.etFecha);
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Material_Dialog_MinWidth, mDateSetListener, year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String dia,mes,año;
                if(dayOfMonth<10){
                    dia=("0"+dayOfMonth);
                } else{
                    dia = Integer.toString(dayOfMonth);
                }
                if(month<9){
                    mes=("0"+(month+1));
                } else{
                    mes = Integer.toString(month+1);
                }
                String date = dia+"/"+mes+"/"+year;
                fecha.setText(date);
            }
        };


    }

    public String Edad(int day, int month, int year){
        String edad ="";
        Calendar cal = Calendar.getInstance();
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH)+1;
        int año = cal.get(Calendar.YEAR);

        if(month<=mes){
            if(month==mes&&day>dia){
                edad=getResources().getString(R.string.tu_edad_es)+(año-year)+getResources().getString(R.string.años);
            }else {
                edad=getResources().getString(R.string.tu_edad_es)+(año-year-1)+getResources().getString(R.string.años);
            }
        }else {
            edad=getResources().getString(R.string.tu_edad_es)+(año-year)+getResources().getString(R.string.años);
        }
        return edad;
    }

    public String Zodiaco(String fechaNac){
        String signo = "";

        int dia = Integer.parseInt(fechaNac.substring(0,2));
        int mes = Integer.parseInt(fechaNac.substring(3,5));
        int año = Integer.parseInt(fechaNac.substring(6));

        switch (mes) {
            case 1:
                if (dia > 21) {
                    signo = getResources().getString(R.string.acuario);
                } else {
                    signo = getResources().getString(R.string.capricornio);
                }
                break;
            case 2:
                if (dia > 19) {
                    signo = getResources().getString(R.string.piscis);
                } else {
                    signo = getResources().getString(R.string.acuario);
                }
                break;
            case 3:
                if (dia > 20) {
                    signo = getResources().getString(R.string.aries);
                } else {
                    signo = getResources().getString(R.string.piscis);
                }
                break;
            case 4:
                if (dia > 20) {
                    signo = getResources().getString(R.string.tauro);
                } else {
                    signo = getResources().getString(R.string.aries);
                }
                break;
            case 5:
                if (dia >= 21) {
                    signo = getResources().getString(R.string.geminis);
                } else {
                    signo = getResources().getString(R.string.tauro);
                }
                break;
            case 6:
                if (dia > 20) {
                    signo = getResources().getString(R.string.cancer);
                } else {
                    signo = getResources().getString(R.string.geminis);
                }
                break;
            case 7:
                if (dia > 22) {
                    signo = getResources().getString(R.string.leo);
                } else {
                    signo = getResources().getString(R.string.cancer);
                }
                break;
            case 8:
                if (dia > 21) {
                    signo = getResources().getString(R.string.virgo);
                } else {
                    signo = getResources().getString(R.string.leo);
                }
                break;
            case 9:
                if (dia > 22) {
                    signo = getResources().getString(R.string.libra);
                } else {
                    signo = getResources().getString(R.string.virgo);
                }
                break;
            case 10:
                if (dia > 22) {
                    signo = getResources().getString(R.string.escorpion);
                } else {
                    signo = getResources().getString(R.string.libra);
                }
                break;
            case 11:
                if (dia > 21) {
                    signo = getResources().getString(R.string.sagitario);
                } else {
                    signo = getResources().getString(R.string.escorpion);
                }
                break;
            case 12:
                if (dia > 21) {
                    signo = getResources().getString(R.string.capricornio);
                } else {
                    signo = getResources().getString(R.string.sagitario);
                }
                break;
        }

        return signo;
    }

    public String Rfc(String nom, String apPat, String apMat, String fechaNac){
        return apPat.toUpperCase().substring(0,2)+apMat.toUpperCase().substring(0,1)+nom.toUpperCase().substring(0,1)+
                fechaNac.substring(8)+fechaNac.substring(3,5)+fechaNac.substring(0,2);
    }
    
    public void Siguietnte(View view){
        String name = nombre.getText().toString();
        String fnPat = apPat.getText().toString();
        String fnMat = apMat.getText().toString();
        String fechaNac = fecha.getText().toString();

        int dia = Integer.parseInt(fechaNac.substring(0,2));
        int mes = Integer.parseInt(fechaNac.substring(3,5));
        int año = Integer.parseInt(fechaNac.substring(6));

        String nombreEnviar = name.toUpperCase()+" "+fnPat.toUpperCase()+" "+fnMat.toUpperCase();
        String edadEnviar = Edad(dia,mes,año);
        String rfcEnviar = Rfc(name,fnPat,fnMat,fechaNac);
        String signoEnviar = Zodiaco(fechaNac);

        Intent siguiente = new Intent(this, Main2Activity.class);
        siguiente.putExtra("nombre", nombreEnviar);
        siguiente.putExtra("edad", edadEnviar);
        siguiente.putExtra("signo", signoEnviar);
        siguiente.putExtra("rfc", rfcEnviar);
        startActivity(siguiente);

    }

}
