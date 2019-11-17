package com.gzeinnumer.kadefootballleague

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_data.*
import kotlinx.android.synthetic.main.item_data.view.*



class FootBallAdapter(private val context: Context,
                      private val list : MutableList<Item>,
                      private val listener: (Item)-> Unit)
    : RecyclerView.Adapter<FootBallAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder
            = MyHolder(LayoutInflater.from(context).inflate(R.layout.item_data, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bindItem(list[position], listener)
    }

    class MyHolder(override val containerView : View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item: Item, listener: (Item) -> Unit) {
            name_item.text = item.title
            item.icon.let {
                Picasso.get().load(it).fit().into(img_item)
            }
            containerView.setOnClickListener{
                listener(item)
            }
        }
    }
}