package kz.flyingv.uikit.decoration

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import kz.flyingv.uikit.theme.accent
import kz.flyingv.uikit.theme.primary
import kz.flyingv.uikit.theme.primaryVariant

val shutAppGradient = Brush.verticalGradient(listOf(primary, accent))

val welcomeGradient2 = Brush.radialGradient(listOf(primary, accent, Color.Transparent))

val welcomeGradientPrimary = object : ShaderBrush() {
    override fun createShader(size: Size): Shader {
        val biggerDimension = maxOf(size.height, size.width)
        return RadialGradientShader(
            colors = listOf(primary.copy(alpha = .7f), Color.Transparent),
            center = size.center,
            radius = biggerDimension / 2.3f,
            colorStops = listOf(0f, 0.95f)
        )
    }
}

val welcomeGradientAccent = object : ShaderBrush() {
    override fun createShader(size: Size): Shader {
        val biggerDimension = maxOf(size.height, size.width)
        return RadialGradientShader(
            colors = listOf(primaryVariant.copy(alpha = .85f), Color.Transparent),
            center = size.center.copy(y = biggerDimension / 2.5f),
            radius = biggerDimension / 1.8f,
            colorStops = listOf(0f, 0.75f)
        )
    }
}

class Gradient {
}