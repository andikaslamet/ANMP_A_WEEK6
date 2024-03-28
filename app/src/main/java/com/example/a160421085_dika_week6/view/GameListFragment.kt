package com.example.a160421085_dika_week6.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160421085_dika_week6.R
import com.example.a160421085_dika_week6.databinding.FragmentGameListBinding
import com.example.a160421085_dika_week6.viewmodel.ListViewModel

class GameListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val studentListAdapter  = GameListAdapter(arrayListOf())
    private lateinit var binding:FragmentGameListBinding
    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentGameListBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = studentListAdapter

        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.loadingLD.observe(viewLifecycleOwner, Observer{
            if(it == true) {
                binding.recyclerView.visibility = View.GONE
                binding.progressBar2.visibility = View.VISIBLE
            } else {
                binding.recyclerView.visibility = View.VISIBLE
                binding.progressBar2.visibility = View.GONE
            }
        })

    }
}