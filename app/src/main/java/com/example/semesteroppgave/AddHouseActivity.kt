package com.example.semesteroppgave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_house.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class AddHouseActivity : AppCompatActivity() {

    var globalHouseType: HouseType? = null

    fun editTextIsNotBlank(editText: EditText): Boolean {
        return !(editText.text.equals(null) || editText.text.equals("") || editText.text.toString()
            .equals("") || editText.text.isNullOrBlank() || editText.text.isEmpty() || editText.text.toString()
            .isEmpty())
    }

    fun addHouse() {
        if (
            editTextIsNotBlank(addressInput_editText) &&
            editTextIsNotBlank(priceInput_editText) &&
            editTextIsNotBlank(sizeInput_editText) &&
            editTextIsNotBlank(cityInput_editText) &&
            editTextIsNotBlank(sizeInput_editText) &&
            globalHouseType != null
        ) {
            val address: String = addressInput_editText.text.toString()
            val price: Int = priceInput_editText.text.toString().toInt()
            val city: String = cityInput_editText.text.toString()
            val size: Int = sizeInput_editText.text.toString().toInt()

            val newHouseObject: HouseConstructor =
                HouseConstructor(address, globalHouseType, price, city, size)
            houseObjectsList.add(newHouseObject)
            finish()
        } else {
            Toast.makeText(this, "One or more inputs are empty", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_house)

        radioGroup_houseTypes.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButton_leilighet -> globalHouseType = HouseType.LEILIGHET
                R.id.radioButton_enebolig -> globalHouseType = HouseType.ENEBOLIG
                R.id.radioButton_rekkehus -> globalHouseType = HouseType.REKKEHUS
                else -> globalHouseType = null
            }
        }

        //Submit house, og returnere til MainActivity
        submitHouse_button.setOnClickListener {
            addHouse()
        }
    }
}
