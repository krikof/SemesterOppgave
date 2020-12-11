package com.example.semesteroppgave

open class HouseConstructor (
    val address: String?,
    val houseType: HouseType?,
    val price: Int?,
    val city: String?,
    val houseSize: Int?
    ) {

    fun returnToStringFormatted () : String {
        return  "Address: ${this.address} \n" +
                "House type: ${this.houseType} \n" +
                "Price: ${this.price} nok\n" +
                "City: ${this.city} \n" +
                "Size: ${this.houseSize} m² \n"
    }

    fun returnForSearch () : String {
        return "${this.address} + \"${this.houseType}\" + \"${this.city}\""
    }
}