package com.kursatkumsuz.payhouserentapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.navigation.fragment.findNavController
import com.kursatkumsuz.payhouserentapp.R
import com.kursatkumsuz.payhouserentapp.adapter.SpinnerAdapter
import com.kursatkumsuz.payhouserentapp.constants.Constants
import com.kursatkumsuz.payhouserentapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var imageButtonOneSelected: Int = 0
    private var imageButtonOneUnSelected: Int = 0
    private var imageButtonTwoSelected: Int = 0
    private var imageButtonTwoUnSelected: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initImages()
        setButtonDrawableTop()
        setSpinner()

    }

    private fun setButtonDrawableTop() {
        binding.tenantButton.setOnClickListener {
            binding.apply {
                tenantButton.startAnimation(AnimationUtils.loadAnimation(context, R.anim.bounce))
                tenantButton.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    imageButtonOneSelected,
                    0,
                    0
                )
                landLordButton.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    imageButtonTwoUnSelected,
                    0,
                    0
                )
            }
        }
        binding.landLordButton.setOnClickListener {
            binding.apply {
                landLordButton.startAnimation(AnimationUtils.loadAnimation(context, R.anim.bounce))
                tenantButton.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    imageButtonOneUnSelected,
                    0,
                    0
                )
                landLordButton.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    imageButtonTwoSelected,
                    0,
                    0
                )
            }
        }

    }

    private fun setSpinner() {

        binding.apply {
            spinner.adapter = SpinnerAdapter(requireContext(), Constants.getImages())
            nextButton.setOnClickListener {
                checkPhoneNumber()
            }
        }
    }

    private fun initImages() {
        imageButtonOneSelected = R.drawable.ic_login_button_one
        imageButtonTwoSelected = R.drawable.ic_login_button_two_selected
        imageButtonOneUnSelected = R.drawable.ic_login_button_one_unselected
        imageButtonTwoUnSelected = R.drawable.ic_login_button_two
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