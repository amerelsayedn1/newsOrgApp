package com.alpha.lazza.data.network.baseRequest

import com.google.gson.annotations.SerializedName

data class ErrorBodyModel(
    @SerializedName("state")
    val state: Boolean = true,
    @SerializedName("msg")
    val message: String = ""
)