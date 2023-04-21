package com.github.xs93.mask

import android.graphics.Rect
import android.view.View
import com.github.xs93.mask.shape.HighLightShape

/**
 *
 *
 * @author XuShuai
 * @version v1.0
 * @date 2023/4/21 14:08
 * @email 466911254@qq.com
 */
internal interface HighLight {

    /**
     *  anchor Rect 瞄点矩形位置
     *
     * @return RectF high Light Rect
     */
    fun getRect(): Rect

    /**
     * 绘制的高亮形状
     *
     * @return HighLightShape
     */
    fun getShape(): HighLightShape

    /**
     * 高亮区域点击事件
     * @return View.OnClickListener?
     */
    fun getHighLightClickListener(): View.OnClickListener?
}