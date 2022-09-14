package com.kursatkumsuz.payhouserentapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kursatkumsuz.payhouserentapp.R
import com.kursatkumsuz.payhouserentapp.databinding.FragmentGetStartedBinding


class GetStartedFragment : Fragment() {


    private lateinit var binding : FragmentGetStartedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGetStartedBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startButton.setOnClickListener {
            findNavController().navigate(R.id.action_getStartedFragment_to_loginFragment)
        }
    }

}