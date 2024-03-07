package kz.flyingv.uikit.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.flyingv.uikit.decoration.shutAppGradient

@Composable
fun LargeButton(
    buttonText: String,
    onClick: () -> Unit?
) {
    
    Box(
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
            .background(shutAppGradient, RoundedCornerShape(8.dp))
            .clickable { onClick() }
    ){

        Text(text = buttonText)

    }
    
}

@Preview
@Composable
fun LargeButtonPreview(){

    LargeButton("Let's start!"){}

}