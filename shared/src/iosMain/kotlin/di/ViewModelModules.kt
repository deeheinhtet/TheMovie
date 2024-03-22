package di

import com.dee.details.presentation.MovieDetailsViewModel
import com.dee.home.presentation.HomeViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by Hein Htet
 */

class ViewModelInjector : KoinComponent {
    val homeViewModel: HomeViewModel by inject()
    val movieDetailsViewModel: MovieDetailsViewModel by inject()
}