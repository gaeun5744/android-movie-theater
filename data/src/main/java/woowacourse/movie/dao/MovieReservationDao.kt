package woowacourse.movie.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import woowacourse.movie.entity.MovieReservation

@Dao
interface MovieReservationDao {
    @Query("SELECT * FROM movie_reservation")
    fun getAll(): List<MovieReservation>

    @Insert
    fun insertAll(vararg movieReservations: MovieReservation)

    @Insert
    fun insert(movieReservation: MovieReservation)

    @Delete
    fun delete(movieReservation: MovieReservation)

    @Query("SELECT * FROM movie_reservation WHERE id==:reservationId")
    fun getMovieReservationById(reservationId: Long): MovieReservation
}
