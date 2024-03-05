package kz.flyingv.shutapp.launch.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaunchScreen(
    viewModel: LaunchViewModel = viewModel()
) {
    
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Launch test") }) }
    ) {
        
        Box(modifier = Modifier.padding(it))
        
    }
    
}