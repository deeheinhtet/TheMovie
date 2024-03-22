package com.dee.details.presentation

import com.dee.core.BaseViewModel
import com.dee.common.mapToErrorDisplay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import modules.moviedetails.domain.MovieDetailsDisplay
import com.dee.details.domain.MovieDetailsUseCase

/**
 * Created by Hein Htet
 */
class MovieDetailsViewModel(private val movieDetailsUseCase: MovieDetailsUseCase) :
    BaseViewModel() {

    override val inputs = MovieDetailsInputs()
    override val outputs = MovieDetailsOutputs()

    private val _movieDetails = MutableStateFlow<MovieDetailsDisplay?>(null)


    inner class MovieDetailsInputs : BaseInputs() {
        fun onGetMovieDetails(id: String) = getMovieDetails(id)
    }

    inner class MovieDetailsOutputs : BaseOutputs() {
        val movieDetails: StateFlow<MovieDetailsDisplay?>
            get() = _movieDetails
    }


    private fun getMovieDetails(id: String) {
        scope.launch {
            movieDetailsUseCase(id)
                .onStart { inputs.emitLoading(true) }
                .onCompletion { inputs.emitLoading(false) }
                .catch { inputs.emitError(it.mapToErrorDisplay()) }
                .collectLatest {
                    _movieDetails.value = it
                }
        }
    }
}
