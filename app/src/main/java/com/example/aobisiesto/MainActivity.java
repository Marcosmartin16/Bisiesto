package com.example.aobisiesto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;

    Button generar;
    Button mostrar;
    TextView txt_aleatorio;
    TextView resultadoFinal;

    RadioGroup radioEstado;
    RadioButton radioSi;
    RadioButton radioNo;

    Switch aSwitch;

    public static boolean esBisiesto(int valorEntero) {

        return (valorEntero % 4 == 0 && valorEntero % 100 != 0) || (valorEntero % 100 == 0 && valorEntero % 400 == 0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int valorEntero = (int) Math.floor(Math.random() * (2500 - 1900 + 1) + 1900);

        ll= (LinearLayout)findViewById(R.id.ll);

        generar = (Button)findViewById(R.id.aleatorio);
        mostrar =(Button)findViewById(R.id.resul);
        txt_aleatorio = (TextView) findViewById(R.id.txt_num_aleatorio);
        resultadoFinal = (TextView) findViewById(R.id.resultado);
        radioEstado = (RadioGroup) findViewById(R.id.rg);

        aSwitch =(Switch) findViewById(R.id.switch1);

        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = String.valueOf(valorEntero);

                txt_aleatorio.setText(numero);

            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                radioNo =(RadioButton)findViewById(R.id.no);
                boolean estadoNo = radioNo.isChecked();
                radioSi = (RadioButton) findViewById(R.id.si);
                boolean estadoSi = radioSi.isChecked();
                String estado1 = radioSi.getText().toString();

                if((estadoSi==false)&&(estadoNo==false)){
                    resultadoFinal.setTextColor(Color.BLUE);
                    resultadoFinal.setText("Debe escoger una de las opciones");
                }
                if((esBisiesto(valorEntero)==true) && (estadoSi==true)) {
                    resultadoFinal.setTextColor(Color.GREEN);
                    resultadoFinal.setText("Correcto");
                }else if((esBisiesto(valorEntero)==true) && (estadoNo==true)) {
                    resultadoFinal.setTextColor(Color.RED);
                    resultadoFinal.setText("Error");
                }
                else if((esBisiesto(valorEntero)==false) && (estadoSi==true)) {
                    resultadoFinal.setTextColor(Color.RED);
                    resultadoFinal.setText("Error");
                }
                else if((esBisiesto(valorEntero)==false) && (estadoNo==true)) {
                    resultadoFinal.setTextColor(Color.GREEN);
                    resultadoFinal.setText("Correcto");
                }

            }
        });

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aSwitch.isChecked()){
                    ll.setBackgroundColor(Color.YELLOW);
                }else {
                    ll.setBackgroundColor(Color.WHITE);
                }
            }
        });
    }
}