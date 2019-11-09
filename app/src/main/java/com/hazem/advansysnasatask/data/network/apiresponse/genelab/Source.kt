package com.hazem.advansysnasatask.data.network.apiresponse.genelab

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("Authoritative Source URL") val AuthoritativeSourceURL: String,
    @SerializedName("Flight Program") val FlightProgram: String,
    @SerializedName("Material Type") val MaterialType: String,
    @SerializedName("Project Identifier") val ProjectIdentifier: String,
    @SerializedName("Accession") val Accession: String,
    @SerializedName("Project Link") val ProjectLink: String,
    @SerializedName("Study Identifier") val StudyIdentifier: String,
    @SerializedName("Study Protocol Name") val StudyProtocolName: String,
    @SerializedName("Study Assay Technology Type") val StudyAssayTechnologyType: String,
    @SerializedName("Acknowledgments") val Acknowledgments: String,
    @SerializedName("Study Assay Technology Platform") val StudyAssayTechnologyPlatform: String,
    @SerializedName("Study Person") val StudyPerson: StudyPersons,
    @SerializedName("Study Protocol Type") val StudyProtocolType: String,
    @SerializedName("Space Program") val SpaceProgram: String,
    @SerializedName("Study Title") val StudyTitle: String,
    @SerializedName("Study Factor Type") val StudyFactorType: String,
    @SerializedName("Study Public Release Date") val StudyPublicReleaseDate: String,
    @SerializedName("Parameter Value") val ParameterValue: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("Study Factor Name") val StudyFactorName: String,
    @SerializedName("Study Assay Measurement Type") val StudyAssayMeasurementType: String,
    @SerializedName("Project Type") val ProjectType: String,
    @SerializedName("Factor Value") val FactorValue: String,
    @SerializedName("Data Source Accession") val DataSourceAccession: String,
    @SerializedName("Data Source Type") val DataSourceType: String,
    @SerializedName("Project Title") val ProjectTitle: String,
    @SerializedName("Study Funding Agency") val StudyFundingAgency: String,
    @SerializedName("Study Protocol Description") val StudyProtocolDescription: String,
    @SerializedName("Experiment Platform") val ExperimentPlatform: String,
    @SerializedName("Characteristics") val Characteristics: String,
    @SerializedName("Study Grant Number") val StudyGrantNumber: String,
    @SerializedName("Study Publication Author List") val StudyPublicationAuthorList: String,
    @SerializedName("Study Publication Title") val StudyPublicationTitle: String,
    @SerializedName("Managing NASA Center") val ManagingNASACenter: String,
    @SerializedName("Study Description") val StudyDescription: String,
    @SerializedName("organism") val organism: String
)

data class StudyPersons(
    @SerializedName("Last Name") val LastName: String,
    @SerializedName("Middle Initials") val MiddleInitials: String,
    @SerializedName("First Name") val FirstName: String
) {
    fun getFirstNamesList() = FirstName.split("     ")
    fun getLastNamesList() = LastName.split("     ")
    fun getMiddleInitialsList() = MiddleInitials.split("     ")

    fun getStudyPersonList(): List<StudyPerson> {
        val list = ArrayList<StudyPerson>()

        val firstNames = getFirstNamesList()
        val lastNames = getLastNamesList()
        val middleInitials = getMiddleInitialsList()

        firstNames.forEachIndexed { index, firstName ->
            val lastName = if (index >= lastNames.size) {
                ""
            } else {
                lastNames[index]
            }
            list.add(StudyPerson(firstName, lastName, ""))
        }
        return list
    }

}

data class StudyPerson(
    val firstName: String, val lastName: String, val middleInitials: String
) {

    fun maskedFirstNameFromStart(): String {
        val sevenbercent = when {
            firstName.length < 3 -> 0
            firstName.length <= 3 -> 2
            else -> (firstName.length * 7) / 10
        }
        val myString = StringBuilder(firstName)

        for (index in 0 until sevenbercent) {
            myString.setCharAt(index, '*')
        }
        return myString.toString()

    }

    fun maskedFirstNameFromEnd(): String {
        val sevenbercent = if (firstName.length <= 3) 2
        else {
            ((firstName.length * 7) / 10)
        }
        val myString = StringBuilder(firstName)

        for (index in (firstName.length - 1) downTo (firstName.length) - sevenbercent) {
            myString.setCharAt(index, '*')
        }
        return myString.toString()

    }
}