package com.github.xs93.mask.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

/**
 * 绘制圆形的高亮shape
 *
 * @author XuShuai
 * @version v1.0
 * @date 2023/4/21 15:03
 * @email 466911254@qq.com
 */
class CircleHighLightShape : HighLightShape {

    override fun drawShape(canvas: Canvas, rect: Rect, paint: Paint) {
        val radius = rect.width().coerceAtLeast(rect.height()) / 2f
        canvas.drawCircle(rect.centerX().toFloat(), rect.centerY().toFloat(), radius, paint)
    }
}