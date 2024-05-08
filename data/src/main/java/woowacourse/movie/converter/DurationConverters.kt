package woowacourse.movie.converter

import androidx.room.TypeConverter
import kotlin.time.Duration

class DurationConverters {
    @TypeConverter
    fun fromDuration(value: Duration?): String? {
        return value?.toString()
    }

    @TypeConverter
    fun toDuration(value: String?): Duration? {
        return value?.let { Duration.parse(it) }
    }
}
