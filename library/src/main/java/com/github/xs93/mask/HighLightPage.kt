package com.github.xs93.mask

import android.graphics.Color
import android.view.View
import androidx.annotation.ColorInt
import com.github.xs93.mask.shape.CircleHighLightShape
import com.github.xs93.mask.shape.HighLightShape
import com.github.xs93.mask.shape.OvalHighLightShape
import com.github.xs93.mask.shape.RoundRectangleHighLightShape

/**
 * 高亮页面配置
 *
 * @author XuShuai
 * @version v1.0
 * @date 2023/4/21 14:57
 * @email 466911254@qq.com
 */
class HighLightPage private constructor(
    internal val highLightList: List<HighLight>,
    internal val backgroundColor: Int,
    internal val touchOutsideCancel: Boolean
) {

    fun detachedFromWindow() {
        highLightList.forEach {
            if (it is ViewHighLight) {
                it.detachedFromWindow()
            }
        }
    }

    class Builder {
        private val mHighLightList = arrayListOf<HighLight>()
        private var mBackgroundColor: Int = Color.argb((0.5 * 255).toInt(), 0, 0, 0)
        private var mTouchOutsideCancel: Boolean = false

        fun addHighLight(
            anchorView: View,
            @HighLightShapeType shapeType: Int,
            padding: Int = 0,
            roundRadius: Float = 0f,
            listener: View.OnClickListener? = null
        ): Builder {
            when (shapeType) {
                HighLightShapeType.CIRCLE -> {
                    mHighLightList.add(
                        ViewHighLight(
                            anchorView,
                            CircleHighLightShape(),
                            padding,
                            padding,
                            padding,
                            padding,
                            listener
                        )
                    )
                }
                HighLightShapeType.OVAL -> {
                    mHighLightList.add(
                        ViewHighLight(
                            anchorView,
                            OvalHighLightShape(),
                            padding,
                            padding,
                            padding,
                            padding,
                            listener
                        )
                    )
                }
                HighLightShapeType.RECTANGLE -> {
                    mHighLightList.add(
                        ViewHighLight(
                            anchorView,
                            RoundRectangleHighLightShape(0f),
                            padding,
                            padding,
                            padding,
                            padding,
                            listener
                        )
                    )
                }
                HighLightShapeType.ROUND_RECTANGLE -> {
                    mHighLightList.add(
                        ViewHighLight(
                            anchorView,
                            RoundRectangleHighLightShape(roundRadius),
                            padding,
                            padding,
                            padding,
                            padding,
                            listener
                        )
                    )
                }
            }
            return this
        }

        fun addHighLight(
            anchorView: View,
            shape: HighLightShape,
            padding: Int = 0,
            listener: View.OnClickListener? = null
        ): Builder {
            mHighLightList.add(
                ViewHighLight(
                    anchorView,
                    shape,
                    padding,
                    padding,
                    padding,
                    padding, listener
                )
            )
            return this
        }

        fun backgroundColor(@ColorInt color: Int): Builder {
            mBackgroundColor = color
            return this
        }


        fun touchOutsideCancel(cancel: Boolean): Builder {
            mTouchOutsideCancel = cancel
            return this
        }

        fun build(): HighLightPage {
            return HighLightPage(mHighLightList, mBackgroundColor, mTouchOutsideCancel)
        }
    }
}