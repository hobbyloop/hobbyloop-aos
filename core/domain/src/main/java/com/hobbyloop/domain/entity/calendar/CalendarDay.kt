package com.hobbyloop.domain.entity.calendar

import com.hobbyloop.domain.entity.class_info.ClassInfo
import com.hobbyloop.domain.entity.class_info.Instructor

/**
 * 달의 시작 요일을 담기 위한 데이터 클래스
 */
enum class DayOfWeek(val dayAbbrevs: String) {
    Sunday(dayAbbrevs = "일"),
    Monday(dayAbbrevs = "월"),
    Tuesday(dayAbbrevs = "화"),
    Wednesday(dayAbbrevs = "수"),
    Thursday(dayAbbrevs = "목"),
    Friday(dayAbbrevs = "금"),
    Saturday(dayAbbrevs = "토");

    companion object {
        // Calendar의 DAY_OF_WEEK 인덱스를 enum으로 매핑하는 함수
        fun from(calendarDayOfWeek: Int): DayOfWeek {
            return entries[(calendarDayOfWeek - 1) % entries.size]
        }
    }
}

enum class DaySelectedStatus {
    NoSelected, Selected, NonClickable, Weekend, Holiday
}

data class CalendarDay(
    val day: Int,
    var status: DaySelectedStatus,
    var reservation: List<Pair<Instructor, List<ClassInfo>>>? = null
)

