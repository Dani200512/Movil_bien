package com.adso.myapplicationsantes

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class FotoFragment : Fragment() {

private lateinit var fotoPreview: ImageView
private val SELECT_PHOTO = 1
    private var photoUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_foto, container, false)
        fotoPreview = view.findViewById(R.id.foto_preview)
        val seleccionarFotoButton: Button = view.findViewById(R.id.seleccionar_foto_button)
        val descripcionEditText: EditText = view.findViewById(R.id.foto_descripcion)
        val submitButton: Button = view.findViewById(R.id.publicar_foto_submit)

        seleccionarFotoButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, SELECT_PHOTO)
        }

        submitButton.setOnClickListener {
            val descripcion = descripcionEditText.text.toString()

            // Aquí puedes agregar la lógica para manejar la publicación de la foto

            if (photoUri != null) {
                Toast.makeText(context, "Foto publicada", Toast.LENGTH_SHORT).show()

                // Inicia la nueva actividad
                val intent = Intent(activity, Home::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(context, "Por favor, selecciona una foto", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SELECT_PHOTO && resultCode == Activity.RESULT_OK) {
            photoUri = data?.data
            fotoPreview.setImageURI(photoUri)
        }
    }
}