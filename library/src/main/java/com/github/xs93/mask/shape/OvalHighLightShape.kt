package com.github.xs93.mask.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF

/**
 *
 *
 * @author XuShuai
 * @version v1.0
 * @date 2023/4/21 15:23
 * @email 466911254@qq.com
 */
class OvalHighLightShape : HighLightShape {

    private val mDrawRect = RectF()
    override fun drawShape(canvas: Canvas, rect: Rect, paint: Paint) {
        mDrawRect.set(rect)
        canvas.drawOval(mDrawRect, paint)
    }
}