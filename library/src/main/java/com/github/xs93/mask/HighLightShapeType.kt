package com.github.xs93.mask

import androidx.annotation.IntDef
import com.github.xs93.mask.HighLightShapeType.Companion.CIRCLE
import com.github.xs93.mask.HighLightShapeType.Companion.OVAL
import com.github.xs93.mask.HighLightShapeType.Companion.RECTANGLE
import com.github.xs93.mask.HighLightShapeType.Companion.ROUND_RECTANGLE

/**
 *
 *
 * @author XuShuai
 * @version v1.0
 * @date 2023/4/21 14:58
 * @email 466911254@qq.com
 */


@IntDef(CIRCLE, OVAL, RECTANGLE, ROUND_RECTANGLE)
@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class HighLightShapeType {
    companion object {
        const val CIRCLE = 1
        const val OVAL = 2
        const val RECTANGLE = 3
        const val ROUND_RECTANGLE = 4
    }
}