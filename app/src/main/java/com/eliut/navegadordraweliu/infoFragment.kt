package com.eliut.navegadordraweliu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class infoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val images = listOf<Image>(
                Image("", R.drawable.img11,"https://www.hechicerafit.com/receta/muffins-de-huevo-con-champinones"),
                Image("", R.drawable.img12,"https://www.hechicerafit.com/receta/batido-de-mango-en-tazon-con-semillas-de-amapola"),
                Image("", R.drawable.img13,"https://www.hechicerafit.com/receta/sencilla-gacha-de-maiz-con-canela-y-duraznos"),
                Image("", R.drawable.img14,"https://www.hechicerafit.com/receta/torta-de-yogur-y-arandanos-con-crocante"),
                Image("", R.drawable.img15,"https://www.hechicerafit.com/receta/refrescante-batido-de-proteina-y-moka")
            )

            val recyclerView = view.findViewById<RecyclerView>(R.id.imagesRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = ImageAdapter(requireContext(), images)




}
}