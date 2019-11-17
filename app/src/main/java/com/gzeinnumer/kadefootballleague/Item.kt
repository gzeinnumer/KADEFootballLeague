package com.gzeinnumer.kadefootballleague

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//androidExtensions {
//    experimental = true
//}
@Parcelize
data class Item(val icon: Int, val title: String) : Parcelable
