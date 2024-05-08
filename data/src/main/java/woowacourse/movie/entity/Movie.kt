package woowacourse.movie.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Contextual
import java.time.Duration
import java.time.LocalDate

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @Contextual @ColumnInfo(name = "start_date") val startDate: LocalDate,
    @Contextual @ColumnInfo(name = "end_date") val endDate: LocalDate,
    @Contextual @ColumnInfo(name = "running_time") val runningTime: Duration,
)
