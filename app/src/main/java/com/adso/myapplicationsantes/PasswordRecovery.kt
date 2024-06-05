package com.adso.myapplicationsantes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PasswordRecovery : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_recovery)

        // Obtener referencias a los elementos de la interfaz
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val enviarButton = findViewById<Button>(R.id.enviarbutton)

        // Configurar el click listener del botón de envío
        enviarButton.setOnClickListener {
            recoverPassword(emailEditText)
        }
    }

    private fun recoverPassword(emailEditText: EditText) {
        val email = emailEditText.text.toString().trim()

        // Validar que el campo de email no esté vacío
        if (email.isEmpty()) {
            emailEditText.error = "Ingresa tu correo electrónico"
            return
        }

        // Aquí puedes implementar la lógica para enviar un correo de recuperación de contraseña
        // utilizando la API o servicio de correo electrónico de tu elección.

        // Ejemplo de código simulado para enviar el correo de recuperación de contraseña
        // Simplemente mostraremos un mensaje de éxito al usuario

        Toast.makeText(
            this,
            "Se ha enviado un correo de recuperación de contraseña a $email",
            Toast.LENGTH_SHORT
        ).show()

        // Regresar a la actividad de inicio de sesiónj
        finish()
    }
}