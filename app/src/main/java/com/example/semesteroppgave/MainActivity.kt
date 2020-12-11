package com.example.semesteroppgave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var globalFilterType: FilterType = FilterType.NO_FILTER

    //Draw house function, with filter logic
    fun drawHouse() {
        when (globalFilterType) {
            FilterType.NO_FILTER -> {
                houseObject_linearLayout.removeAllViews()
                for (house in houseObjectsList) {
                    val newTextView = TextView(this)
                    newTextView.text = house.returnToStringFormatted()
                    houseObject_linearLayout.addView(newTextView)
                }
            }
            FilterType.LEILIGHET -> {
                houseObject_linearLayout.removeAllViews()
                for (house in houseObjectsList) {
                    if (house.houseType == HouseType.LEILIGHET) {
                        val newTextView = TextView(this)
                        newTextView.text = house.returnToStringFormatted()
                        houseObject_linearLayout.addView(newTextView)
                    }
                }
            }
            FilterType.REKKEHUS -> {
                houseObject_linearLayout.removeAllViews()
                for (house in houseObjectsList) {
                    if (house.houseType == HouseType.REKKEHUS) {
                        val newTextView = TextView(this)
                        newTextView.text = house.returnToStringFormatted()
                        houseObject_linearLayout.addView(newTextView)
                    }
                }
            }
            FilterType.ENEBOLIG -> {
                houseObject_linearLayout.removeAllViews()
                for (house in houseObjectsList) {
                    if (house.houseType == HouseType.ENEBOLIG) {
                        val newTextView = TextView(this)
                        newTextView.text = house.returnToStringFormatted()
                        houseObject_linearLayout.addView(newTextView)
                    }
                }
            }
        }
    }

    //Disable remove button if filter option is set
    fun setRemoveButtonOnConditions(enabled: Boolean = false, clickable: Boolean = false) {
        when (globalFilterType) {
            FilterType.NO_FILTER -> {
                removeLastHouseObject_button.isEnabled = enabled
                removeLastHouseObject_button.isClickable = clickable
            }
            else -> {
                removeLastHouseObject_button.isEnabled = enabled
                removeLastHouseObject_button.isClickable = clickable
            }
        }
    }

    //Search function with filter logic
    fun searchFromInput(input: String) {
        when (globalFilterType) {
            FilterType.NO_FILTER -> {
                houseObject_linearLayout.removeAllViews()
                for (house in houseObjectsList) {
                    if (house.address?.contains(input, true) ?: break || house.houseType.toString()
                            .contains(input, true) ?: break || house.city?.contains(
                            input,
                            true
                        ) ?: break
                    ) {
                        val newTextView = TextView(this)
                        newTextView.text = house.returnToStringFormatted()
                        houseObject_linearLayout.addView(newTextView)
                    }
                }
            }
            FilterType.LEILIGHET -> {
                houseObject_linearLayout.removeAllViews()
                for (house in houseObjectsList) {
                    if (house.houseType == HouseType.LEILIGHET) {
                        if (house.address?.contains(
                                input,
                                true
                            ) ?: break || house.houseType?.toString()
                                .contains(input, true) ?: break || house.city?.contains(
                                input,
                                true
                            ) ?: break
                        ) {
                            val newTextView = TextView(this)
                            newTextView.text = house.returnToStringFormatted()
                            houseObject_linearLayout.addView(newTextView)
                        }
                    }
                }
            }
            FilterType.REKKEHUS -> {
                houseObject_linearLayout.removeAllViews()
                for (house in houseObjectsList) {
                    if (house.houseType == HouseType.REKKEHUS) {
                        if (house.address?.contains(
                                input,
                                true
                            ) ?: break || house.houseType?.toString()
                                .contains(input, true) ?: break || house.city?.contains(
                                input,
                                true
                            ) ?: break
                        ) {
                            val newTextView = TextView(this)
                            newTextView.text = house.returnToStringFormatted()
                            houseObject_linearLayout.addView(newTextView)
                        }
                    }
                }
            }
            FilterType.ENEBOLIG -> {
                houseObject_linearLayout.removeAllViews()
                for (house in houseObjectsList) {
                    if (house.houseType == HouseType.ENEBOLIG) {
                        if (house.address?.contains(
                                input,
                                true
                            ) ?: break || house.houseType?.toString()
                                .contains(input, true) ?: break || house.city?.contains(
                                input,
                                true
                            ) ?: break
                        ) {
                            val newTextView = TextView(this)
                            newTextView.text = house.returnToStringFormatted()
                            houseObject_linearLayout.addView(newTextView)
                        }
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Filterspinner
        filter_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                        globalFilterType = FilterType.NO_FILTER
                        drawHouse()
                        setRemoveButtonOnConditions(true, true)
                    }
                    1 -> {
                        globalFilterType = FilterType.LEILIGHET
                        drawHouse()
                        setRemoveButtonOnConditions()
                    }
                    2 -> {
                        globalFilterType = FilterType.REKKEHUS
                        drawHouse()
                        setRemoveButtonOnConditions()
                    }
                    3 -> {
                        globalFilterType = FilterType.ENEBOLIG
                        drawHouse()
                        setRemoveButtonOnConditions()
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        newHouseObject_activity.setOnClickListener {
            val intent = Intent(this, AddHouseActivity::class.java)
            startActivity(intent)
        }

        search_button.setOnClickListener {
            searchFromInput(input_editText.text.toString())
        }

        //Deletes last house object in the defined list
        removeLastHouseObject_button.setOnClickListener {
            when (globalFilterType) {
                FilterType.NO_FILTER -> {
                    if (houseObjectsList.isNotEmpty()) {
                        houseObjectsList.removeLast()
                        drawHouse()
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        houseObject_linearLayout.removeAllViews()
        drawHouse()
    }
}