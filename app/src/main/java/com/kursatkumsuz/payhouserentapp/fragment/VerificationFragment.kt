package com.kursatkumsuz.payhouserentapp.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.kursatkumsuz.payhouserentapp.R
import com.kursatkumsuz.payhouserentapp.databinding.FragmentLoginBinding
import com.kursatkumsuz.payhouserentapp.databinding.FragmentVerificationBinding


class VerificationFragment : Fragment() {

    private lateinit var binding: FragmentVerificationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVerificationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.verifyButton.setOnClickListener {
            checkAllTexts()
        }
    }

    private fun checkAllTexts() {
        val textList = ArrayList<String>(
            arrayListOf(
                binding.codeTextOne.text.toString(),
                binding.codeTextTwo.text.toString(),
                binding.codeTextThree.text.toString(),
                binding.codeTextFour.text.toString(),
                binding.codeTextFive.text.toString(),
                binding.codeTextSix.text.toString()
            )
        )
        for (text in textList) {
            if (text.isEmpty()) {
                Toast.makeText(context, "Code should not be empty", Toast.LENGTH_SHORT).show()
            } else if (!text.isDigitsOnly()) {
                Toast.makeText(context, "Code must be digit", Toast.LENGTH_SHORT).show()
            } else if (text.length > 1) {
                Toast.makeText(context, "Enter only one number per line", Toast.LENGTH_SHORT).show()
            } else {

            }
        }

    }
}