package com.alpha.neworg.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SourceModel(val id: Int = 0, val name: String = "") : Parcelable
