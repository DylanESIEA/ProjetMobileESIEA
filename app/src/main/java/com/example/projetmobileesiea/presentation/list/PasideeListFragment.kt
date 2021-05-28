package com.example.projetmobileesiea.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobileesiea.R
import com.example.projetmobileesiea.presentation.Singletons
import com.example.projetmobileesiea.presentation.api.PokeItemApi
import com.example.projetmobileesiea.presentation.api.PokeItemListResponse
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

        Singletons.pokeItemApi.getDigimonList().enqueue(object : Callback<PokeItemListResponse>{
            override fun onFailure(call: Call<PokeItemListResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<PokeItemListResponse>, response: Response<PokeItemListResponse>) {
                if(response.isSuccessful && response.body() != null){
                   val digimonResponse = response.body()!!
                    adapter.updateList(digimonResponse.results)
                }
            }

        })
        }
        private fun onClickedPokeItem(id: Int) {
            findNavController().navigate(R.id.navigateToPokeItemDetailFragment, bundleOf(
                    "itemId" to (id +1)
            ))
     }


}

