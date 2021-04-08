package com.senne.cifragospel2021.adapter

import android.app.AlertDialog
import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.senne.cifragospel2021.R
import com.senne.cifragospel2021.listener.MusicListener
import com.senne.cifragospel2021.model.SearchModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.my_list_row.view.*

class MyListAdapter(var searchList: List<SearchModel>) : RecyclerView.Adapter<MyListAdapter.MyListAdapterViewHolder>() {

    private lateinit var mListener: MusicListener

    inner class MyListAdapterViewHolder(itemView: View, private val listener: MusicListener): RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener {
        fun bind(searchModel: SearchModel) {

            itemView.myList_titlle.text = searchModel.titulo
            itemView.myList_band.text = searchModel.banda
            if(searchModel.foto == "https://studiosol-a.akamaihd.net/cc/img/desktop/thumb-art.svg?v=3") {
                searchModel.foto = "https://icon-library.com/images/music-icon/music-icon-2.jpg"
            }
            Picasso.get().load(searchModel.foto).into(itemView.myList_foto)
            itemView.myList_container.setOnClickListener {
                listener.onClick(searchModel.titulo, searchModel.banda, searchModel.foto)
            }

            itemView.myList_container.setOnLongClickListener(View.OnLongClickListener {
                AlertDialog.Builder(itemView.context)
                    .setTitle("${searchModel.titulo}")
                    .setMessage(R.string.deseja_remover)
                    .setPositiveButton(R.string.sim) {dialog, which ->
                        listener.onClickMusics(searchModel.banda, searchModel.titulo)
                    }
                    .setNeutralButton(R.string.nao, null)
                    .show()

                true
            })
        }

        override fun onCreateContextMenu(
            menu: ContextMenu?,
            p1: View?,
            p2: ContextMenu.ContextMenuInfo?
        ) {
            if (menu != null) { menu.add(Menu.NONE, R.id.excluir, Menu.NONE, "Excluir") }
            if (menu != null) { menu.add(Menu.NONE, R.id.cancelar, Menu.NONE, "Cancelar") }
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