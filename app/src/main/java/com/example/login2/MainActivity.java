package com.example.login2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Declaración de los elementos
    Button login;
    EditText email;
    EditText pass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        // Asignar el layout principal a la actividad
        setContentView(R.layout.activity_main);

        // Ajustar el padding para respetar las barras del sistema (barra de estado y navegación)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vincular los elementos de la interfaz con los IDs definidos en el layout XML
        email = findViewById(R.id.editTextEmail);
        pass = findViewById(R.id.editTextPassword);
        login = findViewById(R.id.buttonLogin);

        // Configurar la acción del botón de login
        login.setOnClickListener(view -> {
            // Obtener el correo y contraseña ingresados por el usuario
            String correo = email.getText().toString();
            String password = pass.getText().toString();

            // Verificar si el correo y contraseña son correctos
            if (correo.equals("tati47926@gmail.com") && password.equals("12356")) {
                // Si las credenciales son correctas, abrir la integument actividad
                Intent intencion = new Intent(getApplicationContext(), Ventana2.class);
                // Pasar datos adicionales a la siguiente actividad
                intencion.putExtra("email", correo);
                intencion.putExtra("status", 1);
                intencion.putExtra("soltera", true);
                startActivity(intencion);
            } else {
                // Mostrar un mensaje de error si las credenciales son incorrectas
                Toast.makeText(getApplicationContext(), "Verifica el usuario y el password", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
