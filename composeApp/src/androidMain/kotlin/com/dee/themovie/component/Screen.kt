package com.dee.themovie.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dee.themovie.R
import com.dee.themovie.theme.Text16
import com.dee.themovie.utils.collectInLaunchedEffectWithLifecycle
import com.dee.core.BaseViewModel
import com.dee.common.ErrorDisplay
import com.dee.common.mapToErrorDisplay

/**
 * Created by Hein Htet
 */

@Composable
fun Screen(
    vm: BaseViewModel,
    errorContent: @Composable() (() -> Unit?)? = null,
    onRetry: (() -> Unit?)? = null,
    content: @Composable () -> Unit,
) {
    val loading = vm.outputs.loading.collectAsState()
    val errorState = remember { mutableStateOf<ErrorDisplay?>(null) }
    vm.outputs.eventFlow.collectInLaunchedEffectWithLifecycle { event ->
        errorState.value = event.mapToErrorDisplay()
    }
    Box(Modifier.fillMaxSize()) {
        content()
        if (loading.value) LoadingView() else Box {}
        if (errorState.value == null) Box {} else errorContent?.invoke() ?: RenderDefaultError(
            errorState.value,
            onRetry
        )
    }
}

@Composable
fun RenderDefaultError(
    errorDisplay: ErrorDisplay?,
    onRetry: (() -> Unit?)? = null,
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text16(
                text = errorDisplay?.message ?: stringResource(
                    R.string.COMMON_ERROR_MESSAGE
                ),
                modifier = Modifier.padding(36.dp),
                textStyle = TextStyle(textAlign = TextAlign.Center)
            )
            Button(onClick = {
                onRetry?.invoke()
            }) {
                Text16("Retry".uppercase())
            }
        }
    }
}

