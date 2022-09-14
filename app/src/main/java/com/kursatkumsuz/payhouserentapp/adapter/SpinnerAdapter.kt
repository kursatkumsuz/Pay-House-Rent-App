package com.kursatkumsuz.payhouserentapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.kursatkumsuz.payhouserentapp.R
import com.kursatkumsuz.payhouserentapp.databinding.SpinnerLayoutBinding

class SpinnerAdapter(val context: Context, val flagList: List<Int>) : BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return flagList.size
    }

    override fun getItem(position: Int): Any {
        return flagList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val itemHolder: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.spinner_layout, parent, false)
            itemHolder = ItemHolder(view)
            view?.tag = itemHolder
        } else {
            view = convertView
            itemHolder = view.tag as ItemHolder
        }
        itemHolder.img.setImageResource(flagList[position])
        return view
    }

    private class ItemHolder(view: View) {
        val img: ImageView

        init {
            img = view.findViewById(R.id.flagImageView)
        }
    }
}