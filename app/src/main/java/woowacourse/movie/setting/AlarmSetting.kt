package woowacourse.movie.setting

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.ALARM_SERVICE
import woowacourse.movie.model.MovieReservation
import java.time.LocalDateTime
import java.time.ZoneId

class AlarmSetting {
    fun setAlarm(
        context: Context,
        movieReservation: MovieReservation,
    ) {
        val alarmManager = context.getSystemService(ALARM_SERVICE) as AlarmManager

        if (isReservationAfterCurrentTime(movieReservation.screenDateTime)) {
            val triggerTime =
                movieReservation.screenDateTime.minusMinutes(ALARM_OFFSET)
                    .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()

            val pendingIntent = alarmPendingIntent(context, movieReservation)
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent)
        }
    }

    fun cancelAlarm(
        context: Context,
        movieReservation: MovieReservation,
    ) {
        val alarmManager = context.getSystemService(ALARM_SERVICE) as AlarmManager
        val pendingIntent = alarmPendingIntent(context, movieReservation)
        alarmManager.cancel(pendingIntent)
    }

    private fun alarmPendingIntent(
        context: Context,
        movieReservation: MovieReservation,
    ): PendingIntent {
        val intent =
            AlarmReceiver.newIntent(
                context,
                movieReservation.movie.title,
                movieReservation.theaterId,
            )
        return PendingIntent.getBroadcast(
            context,
            movieReservation.id.toInt(),
            intent,
            PendingIntent.FLAG_IMMUTABLE,
        )
    }

    private fun isReservationAfterCurrentTime(screenDateTime: LocalDateTime): Boolean {
        return screenDateTime.isAfter(LocalDateTime.now())
    }

    companion object {
        private const val ALARM_OFFSET = 30L
    }
}