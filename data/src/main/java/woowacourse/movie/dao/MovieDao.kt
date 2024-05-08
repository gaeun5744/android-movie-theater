package woowacourse.movie.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import woowacourse.movie.entity.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getAll(): List<Movie>

    @Insert
    fun insertAll(vararg movies: Movie)

    @Delete
    fun delete(movie: Movie)

    @Query("SELECT * FROM movie WHERE id = :movieId")
    fun getMovieById(movieId: Long): Movie
}
