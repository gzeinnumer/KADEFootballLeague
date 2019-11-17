package com.gzeinnumer.kadefootballleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {

        private var items: MutableList<Item> = mutableListOf()

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout{
                recyclerView {
                    lparams(width = matchParent, height = matchParent)
                    padding = dip(8)

                    val name = resources.getStringArray(R.array.club_name)
                    val image = resources.obtainTypedArray(R.array.club_image)
                    items.clear()
                    for(i in name.indices){
                        items.add(Item(image.getResourceId(i, 0),name[i]))
                    }
                    image.recycle()

                    layoutManager = GridLayoutManager(ctx, 2)
                    adapter = FootBallAdapter(ctx, items){
                        item: Item -> startActivity<DetailActivity>(DetailActivity.DATA to item)
//                        toast("Hay")
                    }
                    hasFixedSize()
                }
            }
        }
    }
}


