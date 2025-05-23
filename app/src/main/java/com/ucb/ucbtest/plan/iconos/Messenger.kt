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

public val Iconos.Messenger: ImageVector
    get() {
        if (_messenger != null) {
            return _messenger!!
        }
        _messenger = Builder(name = "Messenger", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveToRelative(12.0f, 0.0f)
                curveToRelative(-6.627f, 0.0f, -12.0f, 4.974f, -12.0f, 11.111f)
                curveToRelative(0.035f, 3.55f, 1.774f, 6.686f, 4.438f, 8.633f)
                lineToRelative(0.031f, 0.021f)
                verticalLineToRelative(4.235f)
                lineToRelative(4.088f, -2.242f)
                curveToRelative(1.031f, 0.295f, 2.215f, 0.464f, 3.439f, 0.464f)
                horizontalLineToRelative(0.004f)
                curveToRelative(6.627f, 0.0f, 12.0f, -4.975f, 12.0f, -11.11f)
                reflectiveCurveToRelative(-5.373f, -11.112f, -12.0f, -11.112f)
                close()
                moveTo(13.191f, 14.963f)
                lineTo(10.136f, 11.7f)
                lineTo(4.173f, 14.96f)
                lineTo(10.732f, 8.0f)
                lineTo(13.863f, 11.259f)
                lineTo(19.752f, 8.0f)
                close()
            }
        }
        .build()
        return _messenger!!
    }

private var _messenger: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Iconos.Messenger, contentDescription = "")
    }
}
