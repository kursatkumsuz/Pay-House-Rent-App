package com.kursatkumsuz.payhouserentapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.navigation.fragment.findNavController
import com.kursatkumsuz.payhouserentapp.R
import com.kursatkumsuz.payhouserentapp.adapter.SpinnerAdapter
import com.kursatkumsuz.payhouserentapp.constants.Constants
import com.kursatkumsuz.payhouserentapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            spinner.adapter = SpinnerAdapter(requireContext(), Constants.getImages())

            nextButton.setOnClickListener {
                checkPhoneNumber()
            }
        }
    }

    private fun checkPhoneNumber() {
        val phoneNumber = binding.phoneNumberText.text.toString()

        if (phoneNumber.isEmpty()) {
            Toast.makeText(
                context,
                "Phone number cannot be empty",
                Toast.LENGTH_SHORT
            ).show()
        } else if (!phoneNumber.isDigitsOnly()) {
            Toast.makeText(
                context,
                "Phone number must contain numbers only",
                Toast.LENGTH_SHORT
            ).show()
        } else if (phoneNumber.length < 11 || phoneNumber.length > 11) {
            Toast.makeText(
                context,
                "Phone number cannot be less/greater than 11 digits",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            findNavController().navigate(R.id.action_loginFragment_to_verificationFragment)
        }
    }


}