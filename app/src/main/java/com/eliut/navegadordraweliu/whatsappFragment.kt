package com.eliut.navegadordraweliu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class whatsappFragment : Fragment() {


        ////Almuerzo Saludables///
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_whatsapp, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val images = listOf<Image>(
                Image("", R.drawable.img6,"https://www.hechicerafit.com/receta/fideos-de-calabacin-bajos-en-carbohidratos-con-queso-y-atun"),
                Image("", R.drawable.img7,"https://www.hechicerafit.com/receta/avena-rapida-sabor-a-brownie"),
                Image("", R.drawable.img8,"https://www.hechicerafit.com/receta/pechugas-de-pollo-en-salsa-de-naranja-con-quinua"),
                Image("", R.drawable.img9,"https://www.hechicerafit.com/receta/huevos-revueltos-saludables-con-coliflor-y-puerro"),
                Image("", R.drawable.img10,"https://www.hechicerafit.com/receta/escalope-saludable-al-horno-con-batata")
            )

            val recyclerView = view.findViewById<RecyclerView>(R.id.imagesRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = ImageAdapter(requireContext(), images)
        }
    }



