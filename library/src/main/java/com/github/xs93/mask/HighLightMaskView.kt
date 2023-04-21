package com.github.xs93.mask

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.widget.FrameLayout
import kotlin.math.abs

/**
 *
 *
 * @author XuShuai
 * @version v1.0
 * @date 2023/4/21 11:48
 * @email 466911254@qq.com
 */
internal class HighLightMaskView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    var highLightPage: HighLightPage? = null
        set(value) {
            field = value
            invalidate()
        }

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
    private val mXfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    private val mTouchSlop = ViewConfiguration.get(context).scaledTouchSlop

    private var mDownX = 0f
    private var mDownY = 0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                mDownX = event.x
                mDownY = event.y
            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                val upX = event.x
                val upY = event.y
                if (abs(upX - mDownX) < mTouchSlop && abs(upY - mDownY) < mTouchSlop) {
                    val highLights = highLightPage?.highLightList
                    if (highLights != null) {
                        for (highLight in highLights) {
                            val rectF: Rect = highLight.getRect()
                            if (rectF.contains(upX.toInt(), upY.toInt())) {
                                if (highLight is ViewHighLight) {
                                    highLight.getHighLightClickListener()?.onClick(highLight.anchorView)
                                }
                                return true
                            }
                        }
                    }
                    return performClick()
                }
            }
        }
        return super.onTouchEvent(event)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        highLightPage?.let {
            canvas.drawColor(it.backgroundColor)
            canvas.save()
            it.highLightList.forEach { highLight ->
                highLight.getShape().drawShape(canvas, highLight.getRect(), mPaint)
            }
            canvas.restore()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        highLightPage?.detachedFromWindow()
    }


    fun dismiss() {
        val parent = parent
        if (parent != null && parent is ViewGroup) {
            parent.removeView(this)
        }
    }

    init {
        setOnClickListener {
            if (highLightPage?.touchOutsideCancel == false) {
                return@setOnClickListener
            } else {
                dismiss()
            }
        }

        mPaint.xfermode = mXfermode
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        setWillNotDraw(false)
    }
}