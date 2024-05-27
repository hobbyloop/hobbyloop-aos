package com.hobbyloop.feature.reservation.center_detail.yearly_calendar.model

import com.hobbyloop.feature.reservation.center_detail.model.ClassInfo
import com.hobbyloop.feature.reservation.center_detail.model.Instructor

data class DaySelected(
    val year: Int,
    val month: Int,
    val day: Int,
    var classInfoList: List<Pair<Instructor, List<ClassInfo>>>? = null
)

















