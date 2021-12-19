package ar.com.miura.lc.misc

import java.time.LocalDate

class DayOfWeek {
    fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
        val time = LocalDate.of(year, month, day);
        val dayOfWeek:String = time.getDayOfWeek().toString();

        val map = mutableMapOf<String,String>(
            "SUNDAY" to "Sunday",
            "MONDAY" to "Monday",
            "TUESDAY" to "Tuesday",
            "WEDNESDAY" to "Wednesday",
            "THURSDAY" to "Thursday",
            "FRIDAY" to "Friday",
            "SATURDAY" to "Saturday"
        )
        return map.getOrDefault(dayOfWeek, "");
    }
}