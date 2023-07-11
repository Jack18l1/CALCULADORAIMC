package com.eliut.navegadordraweliu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultadoActivity : AppCompatActivity() {

    private lateinit var tvPeso: TextView
    private lateinit var tvAltura: TextView
    private lateinit var tvResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        tvPeso = findViewById(R.id.tv_peso)
        tvAltura = findViewById(R.id.tv_altura)
        tvResultado = findViewById(R.id.tv_resultado)

        val bundle = intent.extras

        if(bundle != null){
            val resultado = bundle.getDouble("resultado")
            var resultadoCalculo: String = imc(resultado)
            var pesoInformado: String = bundle.getDouble("peso").toString()
            var alturaInformada: String = bundle.getDouble("altura").toString()
            tvPeso.text = "Peso  $pesoInformado KG"
            tvAltura.text = "Altura  $alturaInformada M"
            tvResultado.text = resultadoCalculo
        }




    }

    private fun imc(resultado: Double): String{
        return if(resultado < 18.5){
            "Abajo de peso"
        }else if(resultado in 18.5..24.9){
            "Peso normal"
        }else if(resultado in 25.0..29.9){
            "Encima del peso (sobrepeso)"
        }else if(resultado in 30.0..34.9){
            "Obesidad I"
        }else if(resultado in 35.0..39.9){
            "Obesidad II"
        }else{
            "Obesidad III"
        }
    }
}