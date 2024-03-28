package com.example.a160421085_dika_week6.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a160421085_dika_week6.R
import com.example.a160421085_dika_week6.databinding.FragmentGameListBinding

class GameListFragment : Fragment() {
    private lateinit var binding:FragmentGameListBinding
    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentGameListBinding.inflate(inflater, container, false)
        return binding.root
    }

}