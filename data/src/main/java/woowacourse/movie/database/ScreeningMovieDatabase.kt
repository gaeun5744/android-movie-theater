package woowacourse.movie.database

import androidx.room.Database
import woowacourse.movie.dao.ScreeningMovieDao
import woowacourse.movie.entity.ScreeningMovie

@Database(entities = [ScreeningMovie::class], version = 1)
abstract class ScreeningMovieDatabase {
    abstract fun screeningMovieDao(): ScreeningMovieDao
}
