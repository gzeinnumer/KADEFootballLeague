package com.gzeinnumer.kadefootballleague

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_data.*
import kotlinx.android.synthetic.main.item_data.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class FootBallAdapter(private val context: Context,
                      private val list : MutableList<Item>,
                      private val listener: (Item)-> Unit)
    : RecyclerView.Adapter<FootBallAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder
            = MyHolder(FootballUI().createView(AnkoContext.create(parent.context, parent)))
    //HokageViewHolder(HokageUI().createView(AnkoContext.create(parent.context, parent)))

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

    class FootballUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui){
                verticalLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    cardView{
                        padding = dip(10)
                        cardElevation = dip(6).toFloat()
                        background = GradientDrawable().apply {
                            cornerRadius = 8f
                        }
                        verticalLayout {
                            lparams(width = matchParent, height = wrapContent)
                            padding = dip(16)
                            orientation = LinearLayout.VERTICAL
                            gravity = Gravity.CENTER

                            imageView {
                                id = R.id.img_item
                            }.lparams {
                                height = dip(75)
                                width = dip(75)
                            }
                            textView {
                                id = R.id.name_item
                                textSize = 16f
                                textAlignment = View.TEXT_ALIGNMENT_CENTER
                            }.lparams {
                                margin = dip(16)
                            }
                        }
                    }.lparams {
                        margin = dip(6)
                    }
                }
            }
        }
    }
}