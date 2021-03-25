package com.senne.cifragospel2021.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.listener.MusicListener
import com.senne.cifragospel2021.model.MusicsModel
import kotlinx.android.synthetic.main.musics_item_row.view.*


class MusicsAdapter(var searchList: List<MusicsModel>) : RecyclerView.Adapter<MusicsAdapter.MusicsListViewHolder>() {

    private lateinit var mListener: MusicListener

    inner class MusicsListViewHolder(itemView: View, private val listener: MusicListener): RecyclerView.ViewHolder(itemView) {
        fun bind(searchModel: MusicsModel) {
            itemView.musics_titlle.text = searchModel.titulo

            itemView.musics_titlle.setOnClickListener {
                listener.onClickMusics(searchModel.banda, searchModel.titulo)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): MusicsAdapter.MusicsListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.musics_item_row, parent, false)
        return MusicsListViewHolder(view, mListener)
    }



    override fun getItemCount(): Int {
        return searchList.size
    }

    override fun onBindViewHolder(holder: MusicsAdapter.MusicsListViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    fun attachListener(listener: MusicListener) {
        mListener = listener
    }


}