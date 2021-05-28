package com.example.projetmobileesiea.presentation.Detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.projetmobileesiea.R
import com.example.projetmobileesiea.presentation.Singletons
import com.example.projetmobileesiea.presentation.api.PokeItemDetailResponse
import com.example.projetmobileesiea.presentation.api.PokeItemListResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PokeItemDetailFragment : Fragment() {

    private lateinit var textViewName : TextView


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokeitem_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewName = view.findViewById(R.id.poke_item_name)

        //view.findViewById<Button>(R.id.button_second).setOnClickListener {
        //    findNavController().navigate(R.id.navigateToPokeItemListFragment)
        //}

        callApi()
    }

    private fun callApi(){
        val id : Int  = arguments?.getInt("itemId") ?: -1
        Singletons.pokeItemApi.getPokeItemDetail(id).enqueue(object : retrofit2.Callback<PokeItemDetailResponse> {
            override fun onFailure(
                    call: Call<PokeItemDetailResponse>,
                    t: Throwable
            ) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(
                    call: Call<PokeItemDetailResponse>,
                    response: Response<PokeItemDetailResponse>
            ) {
                if(response.isSuccessful && response.body() != null){
                textViewName.text = response.body()!!.name
            }


        }
        })
    }
}
