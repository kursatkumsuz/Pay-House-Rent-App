package com.kursatkumsuz.payhouserentapp.constants

import com.kursatkumsuz.payhouserentapp.R

object Constants {
    fun getImages(): ArrayList<Int> {
        val imageList = ArrayList<Int>()

        imageList.addAll(
            arrayListOf(
                R.drawable.flag_turkey,
                R.drawable.flag_uk,
                R.drawable.flag_german,
                R.drawable.flag_usa,
            )
        )

        return imageList
    }
}