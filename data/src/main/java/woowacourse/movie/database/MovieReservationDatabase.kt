package woowacourse.movie.database

import androidx.room.Database
import woowacourse.movie.dao.MovieReservationDao
import woowacourse.movie.entity.MovieReservation

@Database(entities = [MovieReservation::class], version = 1)
abstract class MovieReservationDatabase {
    abstract fun movieReservationDao(): MovieReservationDao
}
