package com.eliut.navegadordraweliu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class shareFragment : Fragment() {

    ////Postres///
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_share, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val images = listOf<Image>(
            Image("", R.drawable.img1,"https://www.hechicerafit.com/receta/roles-de-canela-integrales"),
            Image("", R.drawable.img2,"https://www.hechicerafit.com/receta/avena-rapida-sabor-a-brownie"),
            Image("", R.drawable.img3,"https://www.hechicerafit.com/recetas/recetas-de-postres-saludables-bajos-en-calorias"),
            Image("", R.drawable.img4,"https://www.hechicerafit.com/receta/lamingtons-de-coco-saludables"),
            Image("", R.drawable.img5,"https://www.hechicerafit.com/receta/tarta-de-gelatina-de-manzana-saludable")
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.imagesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(requireContext(), images)
    }
}
