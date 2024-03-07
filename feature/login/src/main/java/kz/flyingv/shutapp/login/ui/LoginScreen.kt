package kz.flyingv.shutapp.login.ui

import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
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
import kotlinx.coroutines.withContext
import kz.flyingv.shutapp.login.ui.model.LoginStage
import kz.flyingv.uikit.compose.collectAsEffect
import kz.flyingv.uikit.widget.LargeButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {

    val lifecycleOwner = LocalLifecycleOwner.current
    val uiState = viewModel.provideState().collectAsStateWithLifecycle()

    val pagerState = rememberPagerState { LoginStage.entries.size }

    Scaffold { padding ->
        
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false
        ) {
            when(LoginStage.entries[it]){
                LoginStage.Welcome -> Welcome(viewModel, padding)
                LoginStage.Server -> Server(viewModel, padding)
            }
        }

    }

    LaunchedEffect(Unit) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            withContext(Dispatchers.Main.immediate) {
                viewModel.provideEvents().collect {
                    Log.d("provideEvents", it.toString())
                    when(it){
                        LoginEvent.ShowServer -> pagerState.animateScrollToPage(LoginStage.Server.ordinal)
                    }
                }
            }
        }
    }


    
}

@Composable
fun Welcome(viewModel: LoginViewModel, paddingValues: PaddingValues){

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

        Text(
            text = "Welcome to ShutApp!",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        LottieAnimation(
            modifier = Modifier.weight(1f),
            composition = composition,
            iterations = LottieConstants.IterateForever,
        )


        Text(
            text = "Fast, Simple and Open Matrix Client",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        LargeButton(
            buttonText = "Let's start!",
            onClick = { viewModel.reduce(LoginAction.SelectServer) }
        )

        Spacer(modifier = Modifier.height(16.dp))

    }

}

@Composable
fun Server(viewModel: LoginViewModel, paddingValues: PaddingValues){

    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("lottie/server.json"))

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(paddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Pick a Matrix Server!",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        LottieAnimation(
            modifier = Modifier.weight(1f),
            composition = composition,
            iterations = LottieConstants.IterateForever,
        )

/*
        Text(
            text = "Fast, Simple and Open Matrix Client",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )*/

        Spacer(modifier = Modifier.height(24.dp))

        LargeButton(
            buttonText = "Let's start!",
            onClick = {}
        )

        Spacer(modifier = Modifier.height(16.dp))

    }

}