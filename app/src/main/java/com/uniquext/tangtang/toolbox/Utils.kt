package com.uniquext.tangtang.toolbox

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.DisplayMetrics
import android.view.WindowManager
import android.provider.Settings;


/**
 * @author UniqueXT
 * @version 1.0
 * @time 2023/9/11
 */
object Utils {


    /**
     * 获取窗口大小
     */
    fun getWindowsMetrics(manager: WindowManager): DisplayMetrics {
        val displayMetrics = DisplayMetrics()
        manager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics
    }

    /**
     * 跳转悬浮框权限授权页
     */
    fun jumpWindowSettings(context: Context) {
        val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
        intent.data = Uri.parse("package:" + context.packageName)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    /**
     * 跳转到无障碍服务设置页面
     *
     * @param context 设备上下文
     */
    fun jumpToAccessibilitySettings(context: Context) {
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }


    /**
     * 判断是否有悬浮框权限
     */
    fun checkWindowPermission(context: Context): Boolean {
        return Settings.canDrawOverlays(context)
    }

    /**
     * 判断是否开启无障碍服务
     */
    fun checkAccessibilityOpen(context: Context): Boolean {
        val className: String = SkipService::class.java.name
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val runningServices = activityManager.getRunningServices(100)
        for (i in runningServices.indices) {
            val service = runningServices[i].service
            if (service.className == className) {
                return true
            }
        }
        return false
    }

}