package com.senne.cifragospel2021.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.Utility
import com.senne.cifragospel2021.listener.MusicListener
import com.senne.cifragospel2021.model.SearchModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.my_list_row.view.*

class MyListAdapter(var searchList: List<SearchModel>) : RecyclerView.Adapter<MyListAdapter.MyListAdapterViewHolder>() {

    private lateinit var mListener: MusicListener

    inner class MyListAdapterViewHolder(itemView: View, private val listener: MusicListener): RecyclerView.ViewHolder(itemView) {
        fun bind(searchModel: SearchModel) {

            var utility = Utility()
            utility.tamamhoTitle(searchModel.titulo.length,itemView.myList_titlle)
            utility.tamanhoBand(searchModel.banda.length, itemView.myList_band)

            itemView.myList_titlle.text = searchModel.titulo
            itemView.myList_band.text = searchModel.banda
            if(searchModel.foto == "https://studiosol-a.akamaihd.net/cc/img/desktop/thumb-art.svg?v=3") {
                searchModel.foto = "https://icon-library.com/images/music-icon/music-icon-2.jpg"
            }
            Picasso.get().load(searchModel.foto).into(itemView.myList_foto)
            itemView.myList_titlle.setOnClickListener {
                listener.onClick(searchModel.titulo, searchModel.banda, searchModel.foto)
            }

            itemView.myList_delete.setOnClickListener {
                listener.onClickMusics(searchModel.banda, searchModel.titulo)
            }
        }
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): MyListAdapter.MyListAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_list_row, parent, false)
        return MyListAdapterViewHolder(view, mListener)
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    override fun onBindViewHolder(holder: MyListAdapter.MyListAdapterViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    fun attachListener(listener: MusicListener) {
        mListener = listener
    }
}