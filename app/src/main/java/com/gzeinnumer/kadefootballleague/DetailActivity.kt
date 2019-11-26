package com.gzeinnumer.kadefootballleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_data.view.*
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    companion object {
        val DATA = "data"
        var item: Item? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        DetailActivityUI().setContentView(this)


        item = intent.getParcelableExtra<Item>(DATA)

//        toast(item.title)


    }

    class DetailActivityUI : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout {
                item?.icon?.let {
                    Picasso.get().load(it).fit().into(img_item)
                }
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
        }
    }
}

