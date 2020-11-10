package com.example.curriculo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contato extends AppCompatActivity {


    // Botão E-mail
    Button btnEmail;
    Intent intentEnviar;
    String textoEmail = "gabriel.caetano00@gmail.com";

    // Botão Telefone
    Button btnTelefone;
    Intent intentTelefone;
    String textoTelefone  = "(11) 98290-7937";

    // Botão Github
    Button btnGithub;
    Intent intentGitHub;
    String textoGithub = "https://github.com/GabrielFreitas-00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.TemaEscuro);
        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Inicializar componentes
        btnEmail = findViewById(R.id.btnShare);
        btnTelefone = findViewById(R.id.btnTelefone);
        btnGithub = findViewById(R.id.btnGitHub);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentEnviar = new Intent(android.content.Intent.ACTION_SEND);
                intentEnviar.setType("text/plain");
                intentEnviar.putExtra(Intent.EXTRA_SUBJECT,"Currículo Gabriel");
                intentEnviar.putExtra(Intent.EXTRA_TEXT,textoEmail);
                startActivity(Intent.createChooser(intentEnviar,"Compartilhar"));
            }
        });

        btnTelefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentTelefone = new Intent(Intent.ACTION_SEND);
                intentTelefone.setType("text/plain");
                intentTelefone.putExtra(Intent.EXTRA_SUBJECT,"Currículo Gabriel");
                intentTelefone.putExtra(Intent.EXTRA_TEXT,textoTelefone);
                startActivity(Intent.createChooser(intentTelefone,"Compartilhar"));
            }
        });

        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentGitHub = new Intent(Intent.ACTION_SEND);
                intentGitHub.setType("text/plain");
                intentGitHub.putExtra(Intent.EXTRA_SUBJECT,"Perfil Github Gabriel");
                intentGitHub.putExtra(Intent.EXTRA_TEXT,textoGithub);
                startActivity(Intent.createChooser(intentGitHub,"Compartilhar"));
            }
        });
    }
}
