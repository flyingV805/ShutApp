package kz.flyingv.shutapp.login.ui

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kz.flyingv.shutapp.login.ui.model.LoginStage
import kz.flyingv.shutapp.login.ui.model.LoginStage.*
import kz.flyingv.uikit.compose.collectAsEffect
import kz.flyingv.uikit.decoration.welcomeGradient2
import kz.flyingv.uikit.decoration.welcomeGradientAccent
import kz.flyingv.uikit.decoration.welcomeGradientPrimary
import kz.flyingv.uikit.widget.LargeButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {

    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleScope = rememberCoroutineScope()

    val uiState = viewModel.provideState().collectAsStateWithLifecycle()
    val pagerState = rememberPagerState { LoginStage.entries.size }

    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("lottie/server.json"))

    Scaffold { padding ->

        Crossfade(
            targetState = uiState.value.setupState,
            label = "",
            animationSpec = tween(durationMillis = 500)
        ) {

            when(it){
                Welcome -> Box(
                    modifier = Modifier.fillMaxSize()
                        .background(welcomeGradientPrimary),
                )
                Server -> Box(
                    modifier = Modifier.fillMaxSize()
                        .background(welcomeGradientAccent),
                )
                Authorization -> Box(
                    modifier = Modifier.fillMaxSize()
                        .background(welcomeGradient2),
                )
            }

        }

        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false
        ) {
            when(LoginStage.entries[it]){
                Welcome -> Welcome(padding){ viewModel.reduce(LoginAction.WelcomeDone) }
                Server -> Server(viewModel, padding, composition)
                Authorization -> Authorize(viewModel, padding)
            }
        }
    }

    LaunchedEffect(key1 = uiState.value.setupState) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            withContext(Dispatchers.Main.immediate) {
                val currentStage = uiState.value.setupState
                pagerState.animateScrollToPage(
                    currentStage.ordinal
                )
            }
        }
    }
    
}

@Composable
fun Welcome(paddingValues: PaddingValues, onDone: ()-> Unit){

    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("lottie/welcome.json"))

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(paddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        LottieAnimation(
            modifier = Modifier.weight(1f),
            composition = composition,
            iterations = LottieConstants.IterateForever,
        )

        Text(
            text = "Welcome to ShutApp!",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Fast, simple and open client for Matrix.\nHigh-end Encryption.\nNo, and there will be no collection of personal data.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        LargeButton(
            buttonText = "Let's start!",
            onClick = { onDone() }
        )

        Spacer(modifier = Modifier.height(16.dp))

    }

}

@Composable
fun Server(viewModel: LoginViewModel, paddingValues: PaddingValues, composition: LottieComposition?){

    val uiState = viewModel.provideState().collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(paddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        LottieAnimation(
            modifier = Modifier.weight(1f),
            composition = composition,
            iterations = LottieConstants.IterateForever,
        )

        Text(
            text = "Pick a Matrix Server!",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

       Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .clickable { viewModel.reduce(LoginAction.ChooseMatrixOrg) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = uiState.value.useMatrixOrg,
                onClick = { viewModel.reduce(LoginAction.ChooseMatrixOrg) }
            )
            Text(
                text = "matrix.org",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary,
                textDecoration = TextDecoration.Underline
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { viewModel.reduce(LoginAction.ChooseCustomServer) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = uiState.value.useCustomServer,
                onClick = { viewModel.reduce(LoginAction.ChooseCustomServer) }
            )

            AnimatedVisibility(visible = !uiState.value.useCustomServer) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Custom Matrix Server",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            AnimatedVisibility(visible = uiState.value.useCustomServer) {
                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    value = uiState.value.customServer,
                    enabled = uiState.value.useCustomServer,
                    prefix = { Text(text = "https://") },
                    onValueChange = {value ->
                        viewModel.reduce(LoginAction.UpdateCustomServer(value))
                    }
                )
            }

        }

        Spacer(modifier = Modifier.height(24.dp))

        Crossfade(targetState = uiState.value.validating, label = "") {
            when(it){
                true -> Box(modifier = Modifier.height(56.dp)){
                    CircularProgressIndicator()
                }
                false -> LargeButton(
                    buttonText = "Authorize",
                    enabled = !uiState.value.validating,
                    onClick = { viewModel.reduce(LoginAction.ServerPicked) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

    }

}

@Composable
fun Authorize(viewModel: LoginViewModel, paddingValues: PaddingValues){

}