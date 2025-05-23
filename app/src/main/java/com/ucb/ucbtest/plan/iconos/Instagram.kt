package com.ucb.ucbtest.plan.iconos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ucb.ucbtest.plan.Iconos
import kotlin.Unit

public val Iconos.Instagram: ImageVector
    get() {
        if (_instagram != null) {
            return _instagram!!
        }
        _instagram = Builder(name = "Instagram", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF0F0F0F)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(12.0f, 18.0f)
                curveTo(15.314f, 18.0f, 18.0f, 15.314f, 18.0f, 12.0f)
                curveTo(18.0f, 8.686f, 15.314f, 6.0f, 12.0f, 6.0f)
                curveTo(8.686f, 6.0f, 6.0f, 8.686f, 6.0f, 12.0f)
                curveTo(6.0f, 15.314f, 8.686f, 18.0f, 12.0f, 18.0f)
                close()
                moveTo(12.0f, 16.0f)
                curveTo(14.209f, 16.0f, 16.0f, 14.209f, 16.0f, 12.0f)
                curveTo(16.0f, 9.791f, 14.209f, 8.0f, 12.0f, 8.0f)
                curveTo(9.791f, 8.0f, 8.0f, 9.791f, 8.0f, 12.0f)
                curveTo(8.0f, 14.209f, 9.791f, 16.0f, 12.0f, 16.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF0F0F0F)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(18.0f, 5.0f)
                curveTo(17.448f, 5.0f, 17.0f, 5.448f, 17.0f, 6.0f)
                curveTo(17.0f, 6.552f, 17.448f, 7.0f, 18.0f, 7.0f)
                curveTo(18.552f, 7.0f, 19.0f, 6.552f, 19.0f, 6.0f)
                curveTo(19.0f, 5.448f, 18.552f, 5.0f, 18.0f, 5.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF0F0F0F)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(1.654f, 4.276f)
                curveTo(1.0f, 5.56f, 1.0f, 7.24f, 1.0f, 10.6f)
                verticalLineTo(13.4f)
                curveTo(1.0f, 16.76f, 1.0f, 18.441f, 1.654f, 19.724f)
                curveTo(2.229f, 20.853f, 3.147f, 21.771f, 4.276f, 22.346f)
                curveTo(5.56f, 23.0f, 7.24f, 23.0f, 10.6f, 23.0f)
                horizontalLineTo(13.4f)
                curveTo(16.76f, 23.0f, 18.441f, 23.0f, 19.724f, 22.346f)
                curveTo(20.853f, 21.771f, 21.771f, 20.853f, 22.346f, 19.724f)
                curveTo(23.0f, 18.441f, 23.0f, 16.76f, 23.0f, 13.4f)
                verticalLineTo(10.6f)
                curveTo(23.0f, 7.24f, 23.0f, 5.56f, 22.346f, 4.276f)
                curveTo(21.771f, 3.147f, 20.853f, 2.229f, 19.724f, 1.654f)
                curveTo(18.441f, 1.0f, 16.76f, 1.0f, 13.4f, 1.0f)
                horizontalLineTo(10.6f)
                curveTo(7.24f, 1.0f, 5.56f, 1.0f, 4.276f, 1.654f)
                curveTo(3.147f, 2.229f, 2.229f, 3.147f, 1.654f, 4.276f)
                close()
                moveTo(13.4f, 3.0f)
                horizontalLineTo(10.6f)
                curveTo(8.887f, 3.0f, 7.722f, 3.002f, 6.822f, 3.075f)
                curveTo(5.945f, 3.147f, 5.497f, 3.277f, 5.184f, 3.436f)
                curveTo(4.431f, 3.819f, 3.819f, 4.431f, 3.436f, 5.184f)
                curveTo(3.277f, 5.497f, 3.147f, 5.945f, 3.075f, 6.822f)
                curveTo(3.002f, 7.722f, 3.0f, 8.887f, 3.0f, 10.6f)
                verticalLineTo(13.4f)
                curveTo(3.0f, 15.113f, 3.002f, 16.278f, 3.075f, 17.178f)
                curveTo(3.147f, 18.055f, 3.277f, 18.503f, 3.436f, 18.816f)
                curveTo(3.819f, 19.569f, 4.431f, 20.181f, 5.184f, 20.564f)
                curveTo(5.497f, 20.723f, 5.945f, 20.853f, 6.822f, 20.925f)
                curveTo(7.722f, 20.998f, 8.887f, 21.0f, 10.6f, 21.0f)
                horizontalLineTo(13.4f)
                curveTo(15.113f, 21.0f, 16.278f, 20.998f, 17.178f, 20.925f)
                curveTo(18.055f, 20.853f, 18.503f, 20.723f, 18.816f, 20.564f)
                curveTo(19.569f, 20.181f, 20.181f, 19.569f, 20.564f, 18.816f)
                curveTo(20.723f, 18.503f, 20.853f, 18.055f, 20.925f, 17.178f)
                curveTo(20.998f, 16.278f, 21.0f, 15.113f, 21.0f, 13.4f)
                verticalLineTo(10.6f)
                curveTo(21.0f, 8.887f, 20.998f, 7.722f, 20.925f, 6.822f)
                curveTo(20.853f, 5.945f, 20.723f, 5.497f, 20.564f, 5.184f)
                curveTo(20.181f, 4.431f, 19.569f, 3.819f, 18.816f, 3.436f)
                curveTo(18.503f, 3.277f, 18.055f, 3.147f, 17.178f, 3.075f)
                curveTo(16.278f, 3.002f, 15.113f, 3.0f, 13.4f, 3.0f)
                close()
            }
        }
        .build()
        return _instagram!!
    }

private var _instagram: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Iconos.Instagram, contentDescription = "")
    }
}
