package woowacourse.movie.database

import androidx.room.Database
import androidx.room.TypeConverters
import woowacourse.movie.converter.ScreenDateTimeConverters
import woowacourse.movie.dao.ScreeningMovieDao
import woowacourse.movie.entity.ScreeningMovie

@Database(entities = [ScreeningMovie::class], version = 1)
@TypeConverters(value = [ScreenDateTimeConverters::class])
abstract class ScreeningMovieDatabase {
    abstract fun screeningMovieDao(): ScreeningMovieDao
}
