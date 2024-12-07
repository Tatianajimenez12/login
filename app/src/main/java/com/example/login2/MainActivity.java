package com.example.login2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button login, register;
    EditText email;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        email = findViewById(R.id.editTextEmail);
        pass = findViewById(R.id.editTextPassword);
        login = findViewById(R.id.buttonLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = email.getText().toString();
                String password = pass.getText().toString();

                // Verificación de las credenciales para crear el branch
                if (correo.equals("ana47926@gmail.com") && password.equals("123")) {
                    // Branch principal - Usuario válido
                    Intent intencion = new Intent(getApplicationContext(), Ventana2.class);
                    intencion.putExtra("email", correo);
                    intencion.putExtra("status", 1);
                    intencion.putExtra("soltera", true);
                    startActivity(intencion);
                } else if (correo.equals("admin@gmail.com") && password.equals("admin123")) {
                    // Branch alternativo - Usuario administrador
                    Intent adminIntent = new Intent(getApplicationContext(), AdminActivity.class);
                    adminIntent.putExtra("email", correo);
                    startActivity(adminIntent);
                } else {
                    // Branch de error - Credenciales inválidas
                    Toast.makeText(getApplicationContext(), "Verifica el usuario y el password", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
}
