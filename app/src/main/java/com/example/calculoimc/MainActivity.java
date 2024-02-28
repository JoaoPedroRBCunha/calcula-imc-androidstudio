package com.example.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private EditText editPeso;
    private EditText editAltura;
    private ImageView imageResultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        imageResultado = findViewById(R.id.imageResultado);
    }

    public void calcularImc(View view) {
        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double resultado = peso / (altura * altura);
        String resultadoFormatado = String.format("%.2f", resultado);

        if(resultado < 18.5) {
            textResultado.setText("Abaixo do Peso Normal" + " ---> " + resultadoFormatado);
            imageResultado.setImageResource(R.drawable.imc1);
        } else if(resultado <= 18.5 || resultado < 24.9) {
            textResultado.setText("Peso Normal" + " ---> " + resultadoFormatado);
            imageResultado.setImageResource(R.drawable.imc2);
        } else if(resultado <= 25.0 || resultado < 29.9) {
            textResultado.setText("Excesso de Peso" + " ---> " + resultadoFormatado);
            imageResultado.setImageResource(R.drawable.imc3);
        } else if(resultado <= 30.0 || resultado < 34.9) {
            textResultado.setText("Obesidade Classe I" + " ---> " + resultadoFormatado);
            imageResultado.setImageResource(R.drawable.imc5);
        } else if(resultado <= 35.0 || resultado < 39.9) {
            textResultado.setText("Obesidade Classe II" + " ---> " + resultadoFormatado);
            imageResultado.setImageResource(R.drawable.imc4);
        } else if(resultado >= 40) {
            textResultado.setText("Obesidade Classe III" + " ---> " + resultadoFormatado);
            imageResultado.setImageResource(R.drawable.imc6);
        }
    }
}