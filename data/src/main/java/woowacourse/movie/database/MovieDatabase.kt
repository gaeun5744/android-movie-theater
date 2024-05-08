package woowacourse.movie.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import woowacourse.movie.converter.DurationConverters
import woowacourse.movie.converter.LocalDateTimeConverters
import woowacourse.movie.dao.MovieDao
import woowacourse.movie.entity.Movie

@Database(entities = [Movie::class], version = 1)
@TypeConverters(value = [DurationConverters::class, LocalDateTimeConverters::class])
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
