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

public val Iconos.Facebook: ImageVector
    get() {
        if (_facebook != null) {
            return _facebook!!
        }
        _facebook = Builder(name = "Facebook", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(12.0f, 2.04f)
                curveTo(6.5f, 2.04f, 2.0f, 6.53f, 2.0f, 12.06f)
                curveTo(2.0f, 17.06f, 5.66f, 21.21f, 10.44f, 21.96f)
                verticalLineTo(14.96f)
                horizontalLineTo(7.9f)
                verticalLineTo(12.06f)
                horizontalLineTo(10.44f)
                verticalLineTo(9.85f)
                curveTo(10.44f, 7.34f, 11.93f, 5.96f, 14.22f, 5.96f)
                curveTo(15.31f, 5.96f, 16.45f, 6.15f, 16.45f, 6.15f)
                verticalLineTo(8.62f)
                horizontalLineTo(15.19f)
                curveTo(13.95f, 8.62f, 13.56f, 9.39f, 13.56f, 10.18f)
                verticalLineTo(12.06f)
                horizontalLineTo(16.34f)
                lineTo(15.89f, 14.96f)
                horizontalLineTo(13.56f)
                verticalLineTo(21.96f)
                curveTo(15.916f, 21.588f, 18.062f, 20.385f, 19.61f, 18.57f)
                curveTo(21.158f, 16.755f, 22.005f, 14.446f, 22.0f, 12.06f)
                curveTo(22.0f, 6.53f, 17.5f, 2.04f, 12.0f, 2.04f)
                close()
            }
        }
        .build()
        return _facebook!!
    }

private var _facebook: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Iconos.Facebook, contentDescription = "")
    }
}
