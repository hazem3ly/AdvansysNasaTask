package com.hazem.advansysnasatask.data.network.apiresponse.genelab

import com.google.gson.annotations.SerializedName
import com.hazem.advansysnasatask.data.network.apiresponse.baseresponse.NasaCommonResponse

data class GenelabBaseResponse(
    @SerializedName("hits") val hits: GenelabData
) : NasaCommonResponse()