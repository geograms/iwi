package com.google.android.material.datepicker;

import android.content.Context;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
class DateStrings {
    private DateStrings() {
    }

    public static q.c getDateRangeString(Long l2, Long l3, SimpleDateFormat simpleDateFormat) {
        if (l2 == null && l3 == null) {
            return new q.c(null, null);
        }
        if (l2 == null) {
            return new q.c(null, getDateString(l3.longValue(), simpleDateFormat));
        }
        if (l3 == null) {
            return new q.c(getDateString(l2.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l2.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l3.longValue());
        if (simpleDateFormat != null) {
            return new q.c(simpleDateFormat.format(new Date(l2.longValue())), simpleDateFormat.format(new Date(l3.longValue())));
        }
        return utcCalendar.get(1) == utcCalendar2.get(1) ? utcCalendar.get(1) == todayCalendar.get(1) ? new q.c(getMonthDay(l2.longValue(), Locale.getDefault()), getMonthDay(l3.longValue(), Locale.getDefault())) : new q.c(getMonthDay(l2.longValue(), Locale.getDefault()), getYearMonthDay(l3.longValue(), Locale.getDefault())) : new q.c(getYearMonthDay(l2.longValue(), Locale.getDefault()), getYearMonthDay(l3.longValue(), Locale.getDefault()));
    }

    public static String getDateString(long j2) {
        return getDateString(j2, null);
    }

    public static String getDayContentDescription(Context context, long j2, boolean z2, boolean z3, boolean z4) {
        String optionalYearMonthDayOfWeekDay = getOptionalYearMonthDayOfWeekDay(j2);
        if (z2) {
            optionalYearMonthDayOfWeekDay = String.format(context.getString(R.string.mtrl_picker_today_description), optionalYearMonthDayOfWeekDay);
        }
        return z3 ? String.format(context.getString(R.string.mtrl_picker_start_date_description), optionalYearMonthDayOfWeekDay) : z4 ? String.format(context.getString(R.string.mtrl_picker_end_date_description), optionalYearMonthDayOfWeekDay) : optionalYearMonthDayOfWeekDay;
    }

    public static String getMonthDay(long j2) {
        return getMonthDay(j2, Locale.getDefault());
    }

    public static String getMonthDayOfWeekDay(long j2) {
        return getMonthDayOfWeekDay(j2, Locale.getDefault());
    }

    public static String getOptionalYearMonthDayOfWeekDay(long j2) {
        return isDateWithinCurrentYear(j2) ? getMonthDayOfWeekDay(j2) : getYearMonthDayOfWeekDay(j2);
    }

    public static String getYearContentDescription(Context context, int i2) {
        return UtcDates.getTodayCalendar().get(1) == i2 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i2)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i2));
    }

    public static String getYearMonth(long j2) {
        return UtcDates.getYearMonthFormat(Locale.getDefault()).format(new Date(j2));
    }

    public static String getYearMonthDay(long j2) {
        return getYearMonthDay(j2, Locale.getDefault());
    }

    public static String getYearMonthDayOfWeekDay(long j2) {
        return getYearMonthDayOfWeekDay(j2, Locale.getDefault());
    }

    private static boolean isDateWithinCurrentYear(long j2) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j2);
        return todayCalendar.get(1) == utcCalendar.get(1);
    }

    public static String getDateString(long j2, SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j2)) : isDateWithinCurrentYear(j2) ? getMonthDay(j2) : getYearMonthDay(j2);
    }

    public static String getMonthDay(long j2, Locale locale) {
        return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j2));
    }

    public static String getMonthDayOfWeekDay(long j2, Locale locale) {
        return UtcDates.getAbbrMonthWeekdayDayFormat(locale).format(new Date(j2));
    }

    public static String getYearMonthDay(long j2, Locale locale) {
        return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j2));
    }

    public static String getYearMonthDayOfWeekDay(long j2, Locale locale) {
        return UtcDates.getYearAbbrMonthWeekdayDayFormat(locale).format(new Date(j2));
    }

    public static q.c getDateRangeString(Long l2, Long l3) {
        return getDateRangeString(l2, l3, null);
    }
}
