package dev.jai.billgenerator

import dev.jai.billgenerator.utils.Utils
import org.junit.Assert.assertEquals
import org.junit.Test

class UtilsTest {

    @Test
    fun `addImportDuty returns true`() {
        var value = 10F
        val importDuty = Utils.getImportDuty(value)
        assertEquals(importDuty, 0.5F)
    }

    @Test
    fun `getSalesTax returns true`() {
        var value = 10F
        val importDuty = Utils.getSalesTax(value)
        assertEquals(importDuty, 1F)
    }

    @Test
    fun `formatDecimal returns true`() {
        var value = 10.53678F
        val result = Utils.formatDecimal(value)
        assertEquals(result, "10.55")
    }
}