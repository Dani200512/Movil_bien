package com.adso.myapplicationsantes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class Home2Fragment : Fragment() {

    private var likeCount = 0
    private var commentCount = 0
    private var isLiked = false
    private lateinit var likeButton: MaterialButton
    private lateinit var likeCountTextView: TextView
    private lateinit var commentButton: Button
    private lateinit var shareButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home2, container, false)

        // Inicializar vistas
        likeButton = view.findViewById(R.id.likeButton)
        likeCountTextView = view.findViewById(R.id.likeCount)
        commentButton = view.findViewById(R.id.commentButton)
        shareButton = view.findViewById(R.id.shareButton)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Manejar clic en el botón de "Like"
        likeButton.setOnClickListener {
            isLiked = !isLiked

            if (isLiked) {
                // Incrementar el contador de likes
                likeCount++
                // Actualizar el texto del contador de likes
                likeCountTextView.text = "$likeCount Likes"
                // Cambiar el icono de "Like" al hacer clic (rellenado)
                likeButton.setIconResource(R.drawable.likere)
                // Cambiar el color del icono al hacer clic
                likeButton.setIconTintResource(R.color.blue) // Asegúrate de tener este color en tu archivo colors.xml
            } else {
                // Decrementar el contador de likes
                likeCount--
                // Actualizar el texto del contador de likes
                likeCountTextView.text = "$likeCount Likes"
                // Cambiar el icono de "Like" al hacer clic (no rellenado)
                likeButton.setIconResource(R.drawable.like2)
                // Restaurar el color del icono
                likeButton.setIconTintResource(R.color.default_icon_color) // Asegúrate de tener este color en tu archivo colors.xml
            }
        }

        // Manejar clic en el botón de "Comment"
        commentButton.setOnClickListener {

            val intent = Intent(activity, Comment::class.java)
            startActivity(intent)
        }

        // Manejar clic en el botón de "Share"
        shareButton.setOnClickListener {

        }
    }
}