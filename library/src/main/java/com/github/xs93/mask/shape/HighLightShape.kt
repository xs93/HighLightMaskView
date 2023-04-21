package com.github.xs93.mask.shape

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

/**
 *
 *
 * @author XuShuai
 * @version v1.0
 * @date 2023/4/21 14:18
 * @email 466911254@qq.com
 */
interface HighLightShape {

    fun drawShape(canvas: Canvas, rect: Rect, paint: Paint)
}