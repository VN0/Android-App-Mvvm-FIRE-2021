package com.senne.cifragospel2021.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.listener.MusicListener
import com.senne.cifragospel2021.model.AllModel
import com.senne.cifragospel2021.view.AllFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.all_item_row.view.*

class AllAdapter(private val context: AllFragment) : RecyclerView.Adapter<AllAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<AllModel>()
    private lateinit var mListener: MusicListener

    fun setListData(data: MutableList<AllModel>) {
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.all_item_row, parent, false)
        return MainViewHolder(view, mListener)
    }

    override fun getItemCount(): Int {
        return if (dataList.size > 0)  dataList.size else  0
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = dataList[position]
        holder.bindView(user)
    }

    fun attachListener(listener: MusicListener) {
        mListener = listener
    }

    inner class MainViewHolder(itemView: View, private val listener: MusicListener): RecyclerView.ViewHolder(itemView) {
        fun bindView(cifra: AllModel) {
            itemView.all_banda.text = cifra.banda
            Picasso.get().load(cifra.foto).into(itemView.all_photo)

            itemView.all_banda.setOnClickListener {
                listener.onClickAll(cifra.banda)
            }

        }
    }
}