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

public val Iconos.X: ImageVector
    get() {
        if (_x != null) {
            return _x!!
        }
        _x = Builder(name = "X", defaultWidth = 512.0.dp, defaultHeight = 462.8.dp, viewportWidth =
                512.0f, viewportHeight = 462.8f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(403.23f, 0.0f)
                horizontalLineToRelative(78.51f)
                lineTo(310.22f, 196.04f)
                lineTo(512.0f, 462.8f)
                lineTo(354.0f, 462.8f)
                lineTo(230.26f, 301.01f)
                lineTo(88.67f, 462.8f)
                horizontalLineToRelative(-78.56f)
                lineToRelative(183.46f, -209.68f)
                lineTo(0.0f, 0.0f)
                horizontalLineToRelative(162.0f)
                lineToRelative(111.86f, 147.88f)
                lineTo(403.23f, 0.0f)
                close()
                moveTo(375.67f, 415.8f)
                horizontalLineToRelative(43.51f)
                lineTo(138.36f, 44.53f)
                horizontalLineToRelative(-46.68f)
                lineToRelative(283.99f, 371.28f)
                close()
            }
        }
        .build()
        return _x!!
    }

private var _x: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Iconos.X, contentDescription = "")
    }
}
