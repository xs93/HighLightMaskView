package com.github.xs93.mask

import android.app.Activity
import android.view.ViewGroup

/**
 *
 *
 * @author XuShuai
 * @version v1.0
 * @date 2023/4/21 16:45
 * @email 466911254@qq.com
 */
object HighLightMask {


    fun showPage(activity: Activity, page: HighLightPage) {
        val decorView = activity.window.decorView as ViewGroup
        val maskView = HighLightMaskView(activity).apply {
            highLightPage = page
        }

        val params = ViewGroup.LayoutParams(-1, -1)
        decorView.addView(maskView, params)
    }
}