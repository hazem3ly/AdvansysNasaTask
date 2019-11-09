package com.hazem.advansysnasatask.model

import com.hazem.advansysnasatask.data.Const
import com.hazem.advansysnasatask.data.network.apiresponse.genelab.GenelabResponse
import com.hazem.advansysnasatask.data.network.apiresponse.genelab.StudyPerson
import java.io.Serializable

data class GenelabResponseModel(
    val StudyTitle: String,
    val StudyDescription: String,
    val StudyPersons: List<StudyPerson>,
    val organism: String,
    val StudyPublicationTitle: String,
    val fullImagePath: String
) : Serializable {

    companion object {
        fun createCharacter(genelabResponse: GenelabResponse) = GenelabResponseModel(
            genelabResponse.source.StudyTitle,
            genelabResponse.source.StudyDescription,
            genelabResponse.source.StudyPerson.getStudyPersonList(),
            genelabResponse.source.organism,
            genelabResponse.source.StudyPublicationTitle,
            Const.BASE_URL + genelabResponse.source.thumbnail
        )
    }

}

data class GenelabResponseListModel(val list: List<GenelabResponseModel> = arrayListOf())