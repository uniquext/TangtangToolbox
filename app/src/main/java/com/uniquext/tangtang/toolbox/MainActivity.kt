package com.uniquext.tangtang.toolbox

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import com.uniquext.autoclick.AutoClickService
import com.uniquext.compose.activity.BasicComposeActivity
import com.uniquext.util.system.SettingPager

class MainActivity : BasicComposeActivity() {

    private val accessibilityIsOpen = MutableLiveData(false)
    override val customContent: @Composable () -> Unit
        get() = {
            val status by accessibilityIsOpen.observeAsState()
            TextButton(
                enabled = !status!!,
                onClick = { SettingPager.jumpToAccessibilitySettings(this@MainActivity) }
            ) {
                Text(text = "自动跳过服务${if (status!!) "已" else "未"}开启")
            }
        }

    override fun onResume() {
        super.onResume()
        accessibilityIsOpen.value = SettingPager.checkAccessibilityOpen(this, AutoClickService::class.java)
    }
}