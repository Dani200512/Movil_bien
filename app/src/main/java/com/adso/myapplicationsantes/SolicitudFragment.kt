package com.adso.myapplicationsantes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class SolicitudFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_solicitud, container, false)

        val nombreEditText: EditText = view.findViewById(R.id.solicitud_empleo_nombre)
        val emailEditText: EditText = view.findViewById(R.id.solicitud_empleo_email)
        val telefonoEditText: EditText = view.findViewById(R.id.solicitud_empleo_telefono)
        val experienciaEditText: EditText = view.findViewById(R.id.solicitud_empleo_experiencia)
        val submitButton: Button = view.findViewById(R.id.solicitud_empleo_submit)

        submitButton.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val email = emailEditText.text.toString()
            val telefono = telefonoEditText.text.toString()
            val experiencia = experienciaEditText.text.toString()

            // Aquí puedes agregar la lógica para manejar la solicitud de empleo

            Toast.makeText(context, "Solicitud publicada", Toast.LENGTH_SHORT).show()

            // Inicia la nueva actividad
            val intent = Intent(activity, Home::class.java)
            startActivity(intent)
        }

        return view
    }
}