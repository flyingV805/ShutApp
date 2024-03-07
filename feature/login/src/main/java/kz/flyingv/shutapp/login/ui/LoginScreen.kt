package kz.flyingv.shutapp.login.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    
    Scaffold {

        val composition by rememberLottieComposition(LottieCompositionSpec.Asset("lottie/welcome.json"))
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
        )
        
        Box(modifier = Modifier.padding(it)){
            Text(text = "LOGIN!!!!")
        }

    }
    
}