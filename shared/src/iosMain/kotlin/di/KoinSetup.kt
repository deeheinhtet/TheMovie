package di

import com.dee.localdata.localDataModule
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = localDataModule + sharedModules
    startKoin {
        modules(modules)
    }
}
