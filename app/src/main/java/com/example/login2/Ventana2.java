package com.example.login2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ventana2 extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);

        // Manejo de los Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtener extras del intent con validaciones
        String correo = getIntent().getStringExtra("email");
        int status = getIntent().getIntExtra("status", 0);
        boolean soltera = getIntent().getBooleanExtra("soltera", true);

        // Configurar el TextView
        text = findViewById(R.id.texto);
        if (correo != null) {
            text.setText(String.format("Correo: %s\nEstado: %s\nSoltera: %s",
                    correo,
                    status == 0 ? "Inactivo" : "Activo",
                    soltera ? "Sí" : "No"));
        } else {
            text.setText("No se recibió información del usuario.");
        }
    }
}
