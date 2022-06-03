package com.example.myproject.ui.main_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.R
import com.example.myproject.data.models.InformationEntity
import com.example.myproject.databinding.ItemRecyclerBinding

class Adapter (private val click: (info: InformationEntity) -> Unit) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    var list = listOf<InformationEntity>()
    var completeList = mutableListOf<InformationEntity>()

    fun setData(list: List<InformationEntity>) {
        this.list = list
        this.completeList.clear()
        this.completeList.addAll(list)
        notifyDataSetChanged()
    }

    fun filter(text: String){
        list = if(text.isEmpty())
            completeList
        else
            completeList.filter{
                it.weeks?.contains(text, true) ?: false
            }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        val binding = ItemRecyclerBinding.bind(view)
        return ViewHolder(click, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(
        private val click: (info: InformationEntity) -> Unit,
        private val binding: ItemRecyclerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(info: InformationEntity) {
            with(binding){

                itemWeek.text = info.weeks
            }

            itemView.setOnClickListener {
                click.invoke(info)
            }
        }
    }
}