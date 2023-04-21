package com.github.xs93.mask

import android.graphics.Rect
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import com.github.xs93.mask.shape.HighLightShape

/**
 *
 *
 * @author XuShuai
 * @version v1.0
 * @date 2023/4/21 14:22
 * @email 466911254@qq.com
 */
internal class ViewHighLight(
    val anchorView: View,
    private val shape: HighLightShape,
    private val paddingStart: Int = 0,
    private val paddingTop: Int = 0,
    private val paddingEnd: Int = 0,
    private val paddingBottom: Int = 0,
    private val highLightRectClickListener: View.OnClickListener? = null
) : HighLight {


    private val mRect = Rect()
    private val mDrawRect = Rect()
    private val mOnGlobalLayoutListener = OnGlobalLayoutListener {
        val intArray = IntArray(2)
        anchorView.getLocationOnScreen(intArray)
        mRect.set(intArray[0], intArray[1], intArray[0] + anchorView.width, intArray[0] + anchorView.height)
    }

    override fun getRect(): Rect {
        if (anchorView.viewTreeObserver.isAlive) {
            anchorView.viewTreeObserver.removeOnGlobalLayoutListener(mOnGlobalLayoutListener)
            anchorView.viewTreeObserver.addOnGlobalLayoutListener(mOnGlobalLayoutListener)
        }
        val width = anchorView.width
        val height = anchorView.height
        if (width == 0 || height == 0) {
            return mDrawRect
        }
        if (mRect.width() != width || mRect.height() != height) {
            val intArray = IntArray(2)
            anchorView.getLocationOnScreen(intArray)
            mRect.set(intArray[0], intArray[1], intArray[0] + width, intArray[1] + height)
        }
        mDrawRect.set(mRect)
        mDrawRect.left = mDrawRect.left - paddingStart
        mDrawRect.top = mDrawRect.top - paddingTop
        mDrawRect.right = mDrawRect.right + paddingEnd
        mDrawRect.bottom = mDrawRect.bottom + paddingBottom
        return mDrawRect
    }

    override fun getShape(): HighLightShape {
        return shape
    }

    override fun getHighLightClickListener(): View.OnClickListener? {
        return highLightRectClickListener
    }

    fun detachedFromWindow() {
        anchorView.viewTreeObserver.removeOnGlobalLayoutListener(mOnGlobalLayoutListener)
    }
}