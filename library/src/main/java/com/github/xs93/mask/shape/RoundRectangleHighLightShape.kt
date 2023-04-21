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
 * @date 2023/4/21 15:26
 * @email 466911254@qq.com
 */
class RoundRectangleHighLightShape(private val roundRadius: Float) : HighLightShape {

    private val mRectF = RectF()

    override fun drawShape(canvas: Canvas, rect: Rect, paint: Paint) {
        mRectF.set(rect)
        if (roundRadius <= 0) {
            canvas.drawRect(mRectF, paint)
        } else {
            canvas.drawRoundRect(mRectF, roundRadius, roundRadius, paint)
        }
    }
}