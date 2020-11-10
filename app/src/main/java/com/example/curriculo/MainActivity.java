package com.example.curriculo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textEducacao;
    private TextView textDiferencias;
    private TextView textContato;


     public Switch alteraModo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.TemaEscuro);
        } else
            {
                setTheme(R.style.AppTheme);
            }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alteraModo = findViewById(R.id.switchModo);
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES) {
            alteraModo.setChecked(true);
        }
        alteraModo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this,"Modo escuro",
                            Toast.LENGTH_SHORT).show();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartActivity();
                } else {
                    Toast.makeText(MainActivity.this,"Modo Claro",
                            Toast.LENGTH_SHORT).show();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartActivity();
                }
            }
        });

        textContato = findViewById(R.id.textContato);
        textEducacao = findViewById(R.id.textEducacao);
        textDiferencias = findViewById(R.id.textDiferenciais);

        // Text Educação
        textEducacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent educacao = new Intent(getApplicationContext(),Educacao.class);
                Toast.makeText(MainActivity.this,"Educação",Toast.LENGTH_SHORT).show();
                startActivity(educacao);
            }
        });

        // Text Diferenciais
        textDiferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent diferenciais = new Intent(getApplicationContext(),Diferenciais.class);
                Toast.makeText(MainActivity.this,"Diferencias",Toast.LENGTH_SHORT).show();
                startActivity(diferenciais);
            }
        });

        // Text Contato
        textContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contato = new Intent(getApplicationContext(),Contato.class);
                Toast.makeText(MainActivity.this,"Contato",Toast.LENGTH_SHORT).show();
                startActivity(contato);
            }
        });
    }
    private void restartActivity () {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();

    }
}
