package com.example.login2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ventana2 extends AppCompatActivity {
    // Declaración de un objeto TextView para mostrar información en la interfaz
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activa el diseño Edge-to-Edge para una experiencia de pantalla completa
        EdgeToEdge.enable(this);

        // Asigna el diseño XML de la actividad
        setContentView(R.layout.activity_ventana2);

        // Configura el listener para gestionar el espacio de los "window insets" (barras de
