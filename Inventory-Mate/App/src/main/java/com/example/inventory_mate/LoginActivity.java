package com.example.inventory_mate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText;
    Button loginButton;
    TextView forgotPasswordTextView;

    // Credenciales hardcoded para fines de prueba
    private final String hardcodedUsername = "testuser";
    private final String hardcodedPassword = "testpassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar los componentes de la interfaz de usuario
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        forgotPasswordTextView = findViewById(R.id.forgot_password);

        // Establecer el listener de clic para el botón de inicio de sesión
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        // Establecer el listener de clic para el enlace de contraseña olvidada
        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleForgotPassword();
            }
        });
    }

    private void handleLogin() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString();

        // Verificar si las credenciales ingresadas coinciden con las credenciales hardcoded
        if (email.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            // Inicio de sesión exitoso, navegar a HomeActivity
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "Correo electrónico o contraseña inválidos", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleForgotPassword() {

        Toast.makeText(LoginActivity.this, "Funcionalidad de recuperación de contraseña no implementada", Toast.LENGTH_SHORT).show();
    }
}
