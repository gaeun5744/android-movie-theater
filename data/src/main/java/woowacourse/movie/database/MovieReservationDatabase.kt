package woowacourse.movie.database

import androidx.room.Database
import androidx.room.TypeConverters
import woowacourse.movie.converter.DurationConverters
import woowacourse.movie.converter.LocalDateTimeConverters
import woowacourse.movie.converter.ReservationSeatsConverters
import woowacourse.movie.dao.MovieReservationDao
import woowacourse.movie.entity.MovieReservation

@Database(entities = [MovieReservation::class], version = 1)
@TypeConverters(value = [LocalDateTimeConverters::class, DurationConverters::class, ReservationSeatsConverters::class])
abstract class MovieReservationDatabase {
    abstract fun movieReservationDao(): MovieReservationDao
}
