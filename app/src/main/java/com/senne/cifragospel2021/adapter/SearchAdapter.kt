package com.senne.cifragospel2021.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.listener.MusicListener
import com.senne.cifragospel2021.model.CifraModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_cifra.*
import kotlinx.android.synthetic.main.all_item_row.view.*
import kotlinx.android.synthetic.main.search_item_row.view.*

class SearchAdapter(var searchList: List<CifraModel>) : RecyclerView.Adapter<SearchAdapter.SearchListViewHolder>() {

    private lateinit var mListener: MusicListener

    inner class SearchListViewHolder(itemView: View, private val listener: MusicListener): RecyclerView.ViewHolder(itemView) {
        fun bind(searchModel: CifraModel) {
            itemView.search_titlle.text = searchModel.titulo
            itemView.search_band.text = searchModel.banda
            Picasso.get().load(searchModel.foto).into(itemView.search_foto)

            itemView.search_titlle.setOnClickListener {
                listener.onClick(searchModel.titulo, searchModel.banda, searchModel.tom, searchModel.cifra, searchModel.foto)
            }
        }

    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): SearchAdapter.SearchListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item_row, parent, false)
        return SearchListViewHolder(view, mListener)
    }



    override fun getItemCount(): Int {
       return searchList.size
    }

    override fun onBindViewHolder(holder: SearchAdapter.SearchListViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    fun attachListener(listener: MusicListener) {
        mListener = listener
    }


}