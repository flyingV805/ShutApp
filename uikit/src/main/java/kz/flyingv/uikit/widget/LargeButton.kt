package kz.flyingv.uikit.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.flyingv.uikit.decoration.shutAppGradient

@Composable
fun LargeButton(
    buttonText: String,
    enabled: Boolean = true,
    onClick: () -> Unit?
) {
    
    Box(
        modifier = Modifier
            .background(shutAppGradient, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .clickable(enabled = enabled) { onClick() }
            .padding(horizontal = 32.dp, vertical = 16.dp)
    ){

        Text(
            text = buttonText,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = if(enabled) Color.White else Color.White.copy(alpha = .7f)
            )
        )

    }
    
}

@Preview
@Composable
fun LargeButtonPreview(){

    LargeButton("Let's start!"){}

}