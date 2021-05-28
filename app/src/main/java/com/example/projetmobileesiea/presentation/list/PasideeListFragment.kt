package com.example.projetmobileesiea.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobileesiea.R
import com.example.projetmobileesiea.presentation.api.PokeItemApi
import com.example.projetmobileesiea.presentation.api.PokeItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PasideeListFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView
    private val adapter = PasIdeeAdapter(listOf(), :: onClickedPokeItem)


    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pasidee_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.toto_recyclerview)


        recyclerView.apply {
            layoutManager = this@PasideeListFragment.layoutManager
            adapter = this@PasideeListFragment.adapter
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeItemApi : PokeItemApi = retrofit.create(PokeItemApi::class.java)


        pokeItemApi.getDigimonList().enqueue(object : Callback<PokeItemResponse>{
            override fun onFailure(call: Call<PokeItemResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<PokeItemResponse>, response: Response<PokeItemResponse>) {
                if(response.isSuccessful && response.body() != null){
                   val digimonResponse = response.body()!!
                    adapter.updateList(digimonResponse.results)
                }
            }

        })




        }
        private fun onClickedPokeItem(item: item) {
            findNavController().navigate(R.id.navigateToPokeItemDetailFragment)
     }


}

