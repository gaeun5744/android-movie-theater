package woowacourse.movie.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import woowacourse.movie.data.dao.MovieDao
import woowacourse.movie.data.database.MovieDatabase
import woowacourse.movie.data.entity.Movie
import java.io.IOException

class MovieTest {
    private lateinit var movieDao: MovieDao
    private lateinit var db: MovieDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db =
            Room.inMemoryDatabaseBuilder(
                context, MovieDatabase::class.java,
            ).build()
        movieDao = db.movieDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertMovies() {
        movieDao.insertAll(Movie.STUB)

        val movie = movieDao.getAll()
        assertThat(movie).contains(Movie.STUB)
    }
}