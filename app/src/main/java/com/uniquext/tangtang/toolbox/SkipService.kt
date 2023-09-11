package com.uniquext.tangtang.toolbox

import android.accessibilityservice.AccessibilityService
import android.app.ActivityManager
import android.content.Context
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo


/**
 * @author UniqueXT
 * @version 1.0
 * @time 2023/9/11
 */
class SkipService : AccessibilityService() {


    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        val rootNodeInfo = event?.source ?: rootInActiveWindow

//        rootNodeInfo.findAccessibilityNodeInfosByText("跳过").forEach {
//            Log.d("####", "node ${it.text}")
//        }

        rootNodeInfo.findAccessibilityNodeInfosByText("跳过").takeUnless { it.isNullOrEmpty() }?.let {
            it[0].performAction(AccessibilityNodeInfo.ACTION_CLICK)
        }
    }

    override fun onInterrupt() {

    }



}