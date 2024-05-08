package woowacourse.movie.database

import androidx.room.Database
import androidx.room.RoomDatabase
import woowacourse.movie.dao.MovieTheaterDao
import woowacourse.movie.entity.MovieTheater

@Database(entities = [MovieTheater::class], version = 1)
abstract class MovieTheaterDatabase : RoomDatabase() {
    abstract fun movieTheaterDao(): MovieTheaterDao
}
