package com.eliut.navegadordraweliu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText

class HomeFragment : Fragment() {

    private lateinit var btnCalcular: Button
    private lateinit var textPeso: TextInputEditText
    private lateinit var textAltura: TextInputEditText
    private var userEmail: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        btnCalcular = rootView.findViewById(R.id.btn_calcular)
        textPeso = rootView.findViewById(R.id.edit_peso)
        textAltura = rootView.findViewById(R.id.edit_altura)

        // Obtener el correo electrónico del Intent si existe
        val intent = activity?.intent
        userEmail = intent?.getStringExtra("userEmail")

        // Mostrar el mensaje de bienvenida si el correo electrónico no es nulo
        if (userEmail != null) {
            val welcomeMessage = "Bienvenido usuario, $userEmail!" // Personaliza el mensaje de bienvenida según tus necesidades
            Toast.makeText(activity, welcomeMessage, Toast.LENGTH_SHORT).show()
        }

        btnCalcular.setOnClickListener {
            if (textPeso.text.isNullOrBlank()) {
                Toast.makeText(activity, "Ingresa su peso", Toast.LENGTH_SHORT).show()
            } else if (textAltura.text.isNullOrBlank()) {
                Toast.makeText(activity, "Ingresa su altura", Toast.LENGTH_SHORT).show()
            } else {
                val peso: Double = textPeso.text.toString().toDouble()
                val altura: Double = textAltura.text.toString().toDouble()
                val resultado: Double = calcularIMC(peso, altura)

                val intent = Intent(activity, ResultadoActivity::class.java)
                intent.putExtra("resultado", resultado)
                intent.putExtra("peso", peso)
                intent.putExtra("altura", altura)
                startActivity(intent)
            }
        }

        return rootView
    }

    private fun calcularIMC(peso: Double, altura: Double): Double {
        // peso / altura²
        return peso / (altura * altura)
    }
}
