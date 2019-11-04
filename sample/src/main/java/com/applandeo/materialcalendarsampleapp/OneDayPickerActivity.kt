package com.applandeo.materialcalendarsampleapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.applandeo.materialcalendarview.CalendarView
import com.applandeo.materialcalendarview.EventDay
import com.applandeo.materialcalendarview.listeners.OnDayClickListener
import kotlinx.android.synthetic.main.one_day_picker_activity.*
import java.util.*

/**
 * Created by Mateusz Kornakiewicz on 26.05.2017.
 */

class OneDayPickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.one_day_picker_activity)

        val min = Calendar.getInstance().apply { add(Calendar.DAY_OF_MONTH, -2) }
        val max = Calendar.getInstance().apply { add(Calendar.DAY_OF_MONTH, 2) }

        calendarView.setMinimumDate(min)
        calendarView.setMaximumDate(max)

        calendarView.setOnDayClickListener(object : OnDayClickListener {
            override fun onDayClick(eventDay: EventDay) {
                Toast.makeText(applicationContext, getTitle(eventDay), Toast.LENGTH_SHORT).show()
            }
        })

        val getDateButton = findViewById<View>(R.id.getDateButton) as Button
        getDateButton.setOnClickListener {
            for (calendar in calendarView.selectedDates) {
                println(calendar.time.toString())

                Toast.makeText(applicationContext, calendar.time.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getTitle(it: EventDay) = "${it.calendar?.time.toString()} ${it.isEnabled}"
}