package com.hazem.advansysnasatask.data.network.apiresponse.genelab

import com.google.gson.annotations.SerializedName

data class GenelabData(
        @SerializedName("total") val total: Int,
        @SerializedName("hits") val hits: List<GenelabResponse>
)