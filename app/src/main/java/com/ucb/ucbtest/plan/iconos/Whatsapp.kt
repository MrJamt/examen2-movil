package com.ucb.ucbtest.plan.iconos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
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

public val Iconos.Whatsapp: ImageVector
    get() {
        if (_whatsapp != null) {
            return _whatsapp!!
        }
        _whatsapp = Builder(name = "Whatsapp", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(3.5f, 12.0f)
                curveTo(3.5f, 7.306f, 7.306f, 3.5f, 12.0f, 3.5f)
                curveTo(16.694f, 3.5f, 20.5f, 7.306f, 20.5f, 12.0f)
                curveTo(20.5f, 16.694f, 16.694f, 20.5f, 12.0f, 20.5f)
                curveTo(10.328f, 20.5f, 8.771f, 20.018f, 7.458f, 19.186f)
                curveTo(7.214f, 19.031f, 6.914f, 18.99f, 6.637f, 19.073f)
                lineTo(3.758f, 19.932f)
                lineTo(4.842f, 17.395f)
                curveTo(4.97f, 17.096f, 4.944f, 16.752f, 4.772f, 16.475f)
                curveTo(3.966f, 15.176f, 3.5f, 13.644f, 3.5f, 12.0f)
                close()
                moveTo(12.0f, 1.5f)
                curveTo(6.201f, 1.5f, 1.5f, 6.201f, 1.5f, 12.0f)
                curveTo(1.5f, 13.838f, 1.973f, 15.568f, 2.805f, 17.073f)
                lineTo(1.08f, 21.107f)
                curveTo(0.928f, 21.464f, 0.996f, 21.876f, 1.254f, 22.166f)
                curveTo(1.512f, 22.455f, 1.914f, 22.569f, 2.286f, 22.458f)
                lineTo(6.785f, 21.115f)
                curveTo(8.322f, 21.997f, 10.104f, 22.5f, 12.0f, 22.5f)
                curveTo(17.799f, 22.5f, 22.5f, 17.799f, 22.5f, 12.0f)
                curveTo(22.5f, 6.201f, 17.799f, 1.5f, 12.0f, 1.5f)
                close()
                moveTo(14.292f, 14.182f)
                lineTo(12.978f, 15.108f)
                curveTo(12.363f, 14.757f, 11.682f, 14.268f, 11.0f, 13.585f)
                curveTo(10.29f, 12.876f, 9.764f, 12.143f, 9.376f, 11.471f)
                lineTo(10.211f, 10.762f)
                curveTo(10.57f, 10.458f, 10.668f, 9.945f, 10.447f, 9.53f)
                lineTo(9.383f, 7.53f)
                curveTo(9.24f, 7.261f, 8.981f, 7.072f, 8.681f, 7.017f)
                curveTo(8.381f, 6.961f, 8.072f, 7.046f, 7.842f, 7.247f)
                lineTo(7.527f, 7.522f)
                curveTo(6.768f, 8.184f, 6.319f, 9.272f, 6.691f, 10.374f)
                curveTo(7.077f, 11.516f, 7.9f, 13.314f, 9.586f, 15.0f)
                curveTo(11.399f, 16.813f, 13.241f, 17.528f, 14.319f, 17.805f)
                curveTo(15.187f, 18.028f, 16.008f, 17.729f, 16.587f, 17.257f)
                lineTo(17.178f, 16.775f)
                curveTo(17.431f, 16.569f, 17.568f, 16.252f, 17.544f, 15.927f)
                curveTo(17.52f, 15.601f, 17.339f, 15.308f, 17.059f, 15.141f)
                lineTo(15.38f, 14.141f)
                curveTo(15.041f, 13.939f, 14.615f, 13.955f, 14.292f, 14.182f)
                close()
            }
        }
        .build()
        return _whatsapp!!
    }

private var _whatsapp: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Iconos.Whatsapp, contentDescription = "")
    }
}
