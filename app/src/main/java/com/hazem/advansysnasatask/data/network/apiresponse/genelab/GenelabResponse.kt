package com.hazem.advansysnasatask.data.network.apiresponse.genelab

import com.google.gson.annotations.SerializedName

data class GenelabResponse(
    @SerializedName("_index") val index: String,
    @SerializedName("_type") val ype: String,
    @SerializedName("_id") val id: String,
    @SerializedName("_source") val source: Source
)