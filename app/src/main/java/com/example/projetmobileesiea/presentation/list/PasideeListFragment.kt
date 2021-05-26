package com.example.projetmobileesiea.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobileesiea.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PasideeListFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView
    private val adapter = PasIdeeAdapter(listOf())
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

        val pasideeList = arrayListOf<Pasidee>().apply {
            add(Pasidee("test"))
            add(Pasidee("Test"))
            add(Pasidee("test"))
            add(Pasidee("Test"))
        }
        adapter.updateList(pasideeList)

        }

}
