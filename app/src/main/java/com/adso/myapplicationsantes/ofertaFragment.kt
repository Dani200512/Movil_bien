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


class ofertaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_oferta, container, false)

        val tituloEditText: EditText = view.findViewById(R.id.oferta_trabajo_titulo)
        val empresaEditText: EditText = view.findViewById(R.id.oferta_trabajo_empresa)
        val ubicacionEditText: EditText = view.findViewById(R.id.oferta_trabajo_ubicacion)
        val salarioEditText: EditText = view.findViewById(R.id.oferta_trabajo_salario)
        val descripcionEditText: EditText = view.findViewById(R.id.oferta_trabajo_descripcion)
        val submitButton: Button = view.findViewById(R.id.oferta_trabajo_submit)

        submitButton.setOnClickListener {
            val titulo = tituloEditText.text.toString()
            val empresa = empresaEditText.text.toString()
            val ubicacion = ubicacionEditText.text.toString()
            val salario = salarioEditText.text.toString()
            val descripcion = descripcionEditText.text.toString()

            // Aquí puedes agregar la lógica para manejar la oferta de trabajo

            Toast.makeText(context, "Oferta de trabajo publicada", Toast.LENGTH_SHORT).show()

            // Inicia la nueva actividad
            val intent = Intent(activity, Home::class.java)
            startActivity(intent)
        }

        return view
    }
}
