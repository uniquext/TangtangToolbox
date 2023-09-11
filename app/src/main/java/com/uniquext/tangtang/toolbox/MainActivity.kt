package com.uniquext.tangtang.toolbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import com.uniquext.tangtang.toolbox.ui.theme.TangtangToolboxTheme

class MainActivity : ComponentActivity() {

    private val accessibilityIsOpen = MutableLiveData(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TangtangToolboxTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Box {
                        val status by accessibilityIsOpen.observeAsState()
                        TextButton(
                            enabled = !status!!,
                            onClick = { Utils.jumpToAccessibilitySettings(this@MainActivity) }
                        ) {
                            Text(text = "自动跳过服务${if (status!!) "已" else "未"}开启")
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        accessibilityIsOpen.value = Utils.checkAccessibilityOpen(this)
    }
}