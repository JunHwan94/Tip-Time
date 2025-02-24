package com.example.tiptime

import android.icu.text.NumberFormat
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    // androidTest 내 파일에서 @Test 어노테이션이 있으면 계측 테스트로 인식
    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount") // 특정 텍스트가 포함된 노드에 액세스
            .performTextInput("10") // input을 10으로 설정
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip") // 특정 텍스트가 포함된 노드가
            .assertExists("No node with this text was found.") // 존재하는지 확인
    }
}

