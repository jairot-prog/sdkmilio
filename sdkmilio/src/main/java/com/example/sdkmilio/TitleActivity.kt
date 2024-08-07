package com.example.sdkmilio

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.setPadding

class TitleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Obtener el título del Intent

        // Obtener el título del Intent
        val title = intent.getStringExtra("TITLE_KEY") ?: "Default Title"

        // Crear un ConstraintLayout
        val layout = ConstraintLayout(this).apply {
            id = ConstraintLayout.generateViewId()
        }

        // Crear un TextView para el título principal
        val mainTitleView = TextView(this).apply {
            id = ConstraintLayout.generateViewId()
            text = "Main Title"
            textSize = 32f // Tamaño del texto más grande
            setPadding(16) // Padding
            setTextColor(Color.BLACK) // Color del texto
            setTypeface(typeface, android.graphics.Typeface.BOLD) // Negrita
        }

        // Crear un TextView para el título pasado como parámetro
        val subTitleView = TextView(this).apply {
            id = ConstraintLayout.generateViewId()
            text = title
            textSize = 24f // Tamaño del texto
            setPadding(16) // Padding
            setTextColor(Color.parseColor("#80000000")) // Color del texto más opaco
        }

        // Crear un botón para cerrar la actividad
        val closeButton = Button(this).apply {
            id = ConstraintLayout.generateViewId()
            text = "Cancelar"
            setOnClickListener {
                finish()
            }
        }

        // Añadir los TextViews y el botón al layout
        layout.addView(mainTitleView)
        layout.addView(subTitleView)
        layout.addView(closeButton)

        // Configurar las restricciones del ConstraintLayout
        val constraintSet = ConstraintSet().apply {
            clone(layout)
            connect(mainTitleView.id, ConstraintSet.TOP, layout.id, ConstraintSet.TOP, 32)
            connect(mainTitleView.id, ConstraintSet.START, layout.id, ConstraintSet.START, 16)
            connect(mainTitleView.id, ConstraintSet.END, layout.id, ConstraintSet.END, 16)

            connect(subTitleView.id, ConstraintSet.TOP, mainTitleView.id, ConstraintSet.BOTTOM, 16)
            connect(subTitleView.id, ConstraintSet.START, layout.id, ConstraintSet.START, 16)
            connect(subTitleView.id, ConstraintSet.END, layout.id, ConstraintSet.END, 16)

            connect(closeButton.id, ConstraintSet.BOTTOM, layout.id, ConstraintSet.BOTTOM, 32)
            connect(closeButton.id, ConstraintSet.START, layout.id, ConstraintSet.START, 16)
            connect(closeButton.id, ConstraintSet.END, layout.id, ConstraintSet.END, 16)
        }
        constraintSet.applyTo(layout)

        // Establecer el layout como la vista del contenido
        setContentView(layout)
}}
