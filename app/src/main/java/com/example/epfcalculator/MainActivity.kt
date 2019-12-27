package com.example.epfcalculator

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        date_of_birth_id.setOnClickListener {
            val c: Calendar = Calendar.getInstance()
            val currentDay = c.get(Calendar.DAY_OF_MONTH)
            val currentMonth = c.get(Calendar.MONTH)
            val currentYear = c.get(Calendar.YEAR)

            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, day
                ->date_of_birth_id.setText(day.toString()+" / "+(month+1).toString()+" / "+year.toString())

                val age=currentYear-year
                val minSaving=getSaving(age)
                val inversement=minSaving*0.3

                age_id.setText(age.toString())
                min_saving_id.setText("RM"+ minSaving.toString())
                inversement_id.setText("RM"+ inversement.toString())


            },currentYear,currentMonth,currentDay)
            dpd.show()
        }


    }

    fun getSaving(age:Int):Double {
        return when (age) {
            in 16..20 -> 5000.00
            in 21..25 -> 14000.00
            in 25..30 -> 29000.00
            in 31..35 -> 50000.00
            in 36..40 -> 78000.00
            in 41..45 -> 116000.00
            in 46..50 -> 165000.00
            in 51..55 -> 228000.00
            else->0.00
        }
    }

    }


