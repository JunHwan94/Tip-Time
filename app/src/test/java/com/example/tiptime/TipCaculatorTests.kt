package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCaculatorTests {
    // test 내 파일에서 @Test 어노테이션이 있으면 로컬 테스트로 인식
    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        val actualTip = calculateTip(
            roundUp = false,
            amount = amount,
            tipPercent = tipPercent
        )

        assertEquals(expectedTip, actualTip)
    }
}