package com.hazem.advansysnasatask.data.network.apiresponse.baseresponse

import com.google.gson.annotations.SerializedName

open class NasaCommonResponse(
    @SerializedName("took") protected var took: Int = -1,
    @SerializedName("timed_out") protected var timedOut: Boolean = false
) : INasaCommonResponse {
    override fun isSuccess(): Boolean {
        return !timedOut
    }
}