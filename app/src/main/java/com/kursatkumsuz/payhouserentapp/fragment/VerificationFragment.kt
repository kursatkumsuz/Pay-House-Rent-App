package com.kursatkumsuz.payhouserentapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kursatkumsuz.payhouserentapp.databinding.FragmentVerificationBinding


class VerificationFragment : Fragment() {

    private lateinit var binding: FragmentVerificationBinding
    private var textOne = ""
    private var textTwo = ""
    private var textThree = ""
    private var textFour = ""
    private var textFive = ""
    private var textSix = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVerificationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkAllTexts()
        countDownTimer()
        resendCode()
    }

    private fun checkAllTexts() {

        binding.verifyButton.setOnClickListener {

            initTextView()

            if (textOne.isEmpty() ||
                textTwo.isEmpty() ||
                textThree.isEmpty() ||
                textFour.isEmpty() ||
                textFive.isEmpty() ||
                textFive.isEmpty() ||
                textSix.isEmpty()
            ) {
                Toast.makeText(context, "Code should not be empty", Toast.LENGTH_SHORT).show()

            } else if (textOne.length > 1 ||
                textTwo.length > 1 ||
                textThree.length > 1 ||
                textFour.length > 1 ||
                textFive.length > 1 ||
                textFive.length > 1 ||
                textSix.length > 1
            ) {
                Toast.makeText(context, "Enter only one number per line", Toast.LENGTH_SHORT).show()

            } else {
                binding.countText.visibility = View.GONE
                binding.lottieAnimationView.visibility = View.VISIBLE
                binding.lottieAnimationView.playAnimation()
            }
        }

    }

    private fun initTextView() {
        binding.apply {
            textOne = codeTextOne.text.toString()
            textTwo = codeTextTwo.text.toString()
            textThree = codeTextThree.text.toString()
            textFour = codeTextFour.text.toString()
            textFive = codeTextFive.text.toString()
            textSix = codeTextSix.text.toString()
        }
    }

    private fun countDownTimer() {
        object : CountDownTimer(15000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(time: Long) {
                binding.apply {
                    countText.text = "${time / 1000} Sec Left"
                    resendCodeButton.isEnabled = false
                }
            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                binding.apply {
                    countText.text = "Time is over! Resend Code"
                    resendCodeButton.isEnabled = true
                }
            }

        }.start()
    }

    private fun resendCode() {
        binding.resendCodeButton.setOnClickListener {
            countDownTimer()
        }
    }


}