package com.adso.myapplicationsantes

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.VideoView

class videoFragment : Fragment() {

    private lateinit var videoPreview: VideoView
    private val SELECT_VIDEO = 1
    private var videoUri: Uri? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_video, container, false)
        videoPreview = view.findViewById(R.id.video_preview)
        val seleccionarVideoButton: Button = view.findViewById(R.id.seleccionar_video_button)
        val descripcionEditText: EditText = view.findViewById(R.id.video_descripcion)
        val submitButton: Button = view.findViewById(R.id.publicar_video_submit)

        seleccionarVideoButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, SELECT_VIDEO)
        }

        submitButton.setOnClickListener {
            val descripcion = descripcionEditText.text.toString()

            // Aquí puedes agregar la lógica para manejar la publicación del video

            if (videoUri != null) {
                Toast.makeText(context, "Video publicado", Toast.LENGTH_SHORT).show()

                // Inicia la nueva actividad
                val intent = Intent(activity, Home::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(context, "Por favor, selecciona un video", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SELECT_VIDEO && resultCode == Activity.RESULT_OK) {
            videoUri = data?.data
            videoPreview.setVideoURI(videoUri)
            videoPreview.start()
        }
    }
}