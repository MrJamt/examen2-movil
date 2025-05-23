package com.ucb.ucbtest.plan.iconos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ucb.ucbtest.plan.Iconos
import kotlin.Unit

public val Iconos.Telegram: ImageVector
    get() {
        if (_telegram != null) {
            return _telegram!!
        }
        _telegram = Builder(name = "Telegram", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(22.122f, 10.04f)
                curveToRelative(0.006f, -0.0f, 0.014f, -0.0f, 0.022f, -0.0f)
                curveToRelative(0.209f, 0.0f, 0.403f, 0.065f, 0.562f, 0.177f)
                lineToRelative(-0.003f, -0.002f)
                curveToRelative(0.116f, 0.101f, 0.194f, 0.243f, 0.213f, 0.403f)
                lineToRelative(0.0f, 0.003f)
                curveToRelative(0.02f, 0.122f, 0.031f, 0.262f, 0.031f, 0.405f)
                curveToRelative(0.0f, 0.065f, -0.002f, 0.129f, -0.007f, 0.193f)
                lineToRelative(0.0f, -0.009f)
                curveToRelative(-0.225f, 2.369f, -1.201f, 8.114f, -1.697f, 10.766f)
                curveToRelative(-0.21f, 1.123f, -0.623f, 1.499f, -1.023f, 1.535f)
                curveToRelative(-0.869f, 0.081f, -1.529f, -0.574f, -2.371f, -1.126f)
                curveToRelative(-1.318f, -0.865f, -2.063f, -1.403f, -3.342f, -2.246f)
                curveToRelative(-1.479f, -0.973f, -0.52f, -1.51f, 0.322f, -2.384f)
                curveToRelative(0.221f, -0.23f, 4.052f, -3.715f, 4.127f, -4.031f)
                curveToRelative(0.004f, -0.019f, 0.006f, -0.04f, 0.006f, -0.062f)
                curveToRelative(0.0f, -0.078f, -0.029f, -0.149f, -0.076f, -0.203f)
                lineToRelative(0.0f, 0.0f)
                curveToRelative(-0.052f, -0.034f, -0.117f, -0.053f, -0.185f, -0.053f)
                curveToRelative(-0.045f, 0.0f, -0.088f, 0.009f, -0.128f, 0.024f)
                lineToRelative(0.002f, -0.001f)
                quadToRelative(-0.198f, 0.045f, -6.316f, 4.174f)
                curveToRelative(-0.445f, 0.351f, -1.007f, 0.573f, -1.619f, 0.599f)
                lineToRelative(-0.006f, 0.0f)
                curveToRelative(-0.867f, -0.105f, -1.654f, -0.298f, -2.401f, -0.573f)
                lineToRelative(0.074f, 0.024f)
                curveToRelative(-0.938f, -0.306f, -1.683f, -0.467f, -1.619f, -0.985f)
                quadToRelative(0.051f, -0.404f, 1.114f, -0.827f)
                quadToRelative(6.548f, -2.853f, 8.733f, -3.761f)
                curveToRelative(1.607f, -0.853f, 3.47f, -1.555f, 5.429f, -2.01f)
                lineToRelative(0.157f, -0.031f)
                close()
                moveTo(15.93f, 1.025f)
                curveToRelative(-8.302f, 0.02f, -15.025f, 6.755f, -15.025f, 15.06f)
                curveToRelative(0.0f, 8.317f, 6.742f, 15.06f, 15.06f, 15.06f)
                reflectiveCurveToRelative(15.06f, -6.742f, 15.06f, -15.06f)
                curveToRelative(0.0f, -8.305f, -6.723f, -15.04f, -15.023f, -15.06f)
                horizontalLineToRelative(-0.002f)
                quadToRelative(-0.035f, -0.0f, -0.07f, 0.0f)
                close()
            }
        }
        .build()
        return _telegram!!
    }

private var _telegram: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Iconos.Telegram, contentDescription = "")
    }
}
