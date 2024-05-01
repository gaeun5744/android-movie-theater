package woowacourse.movie.screeningmovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import woowacourse.movie.databinding.ItemScreeningAdvertiseBinding
import woowacourse.movie.databinding.ItemScreeningMovieBinding

class MovieAdapter(
    private val movies: List<ScreeningItem>,
    private val adapterClickListener: AdapterClickListener,
) : RecyclerView.Adapter<ScreeningViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return when (movies[position]) {
            is ScreenMovieUiModel -> MOVIE
            is AdvertiseUiModel -> ADVERTISE
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ScreeningViewHolder {
        return when (viewType) {
            MOVIE -> {
                val binding =
                    ItemScreeningMovieBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false,
                    )
                MovieViewHolder(binding, adapterClickListener)
            }

            ADVERTISE -> {
                val binding =
                    ItemScreeningAdvertiseBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false,
                    )
                AdvertiseViewHolder(binding)
            }

            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(
        holder: ScreeningViewHolder,
        position: Int,
    ) {
        when (holder) {
            is MovieViewHolder -> holder.onBind(movies[position] as ScreenMovieUiModel)
            is AdvertiseViewHolder -> {}
        }
    }

    override fun getItemCount(): Int = movies.size

    companion object {
        private const val MOVIE = 0
        private const val ADVERTISE = 1
    }
}
