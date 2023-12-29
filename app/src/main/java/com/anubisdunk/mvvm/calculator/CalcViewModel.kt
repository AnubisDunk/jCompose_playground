package com.anubisdunk.mvvm.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


data class CalcState(
    val num1: String = "",
    val num2: String = "",
    val operation: CalculatorOperation? = null,
)

class CalcViewModel : ViewModel() {
    var state by mutableStateOf(CalcState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalcState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> perfrormCalc()
            is CalculatorAction.Delete -> performDelete()
        }
        //perfrormCalc()
    }

    private fun performDelete() {
        when {
            state.num2.isNotBlank() -> state = state.copy(
                num2 = state.num2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.num1.isNotBlank() -> state = state.copy(
                num1 = state.num1.dropLast(1)
            )
        }
    }


    private fun perfrormCalc() {
        val num1 = state.num1.toDoubleOrNull()
        val num2 = state.num2.toDoubleOrNull()
        if (num1 != null && num2 != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Add -> num1 + num2
                is CalculatorOperation.Sub -> num1 - num2
                is CalculatorOperation.Mul -> num1 * num2
                is CalculatorOperation.Div -> num1 / num2
                null -> return
            }
            state = state.copy(
                num1 = result.toString().take(15),
                num2 = "",
                operation = null
            )
        }

    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.num1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.num1.contains(".") && state.num1.isNotBlank()) {
            state = state.copy(
                num1 = state.num1 + "."
            )
            return
        }
        if (!state.num2.contains(".") && state.num2.isNotBlank()) {
            state = state.copy(
                num2 = state.num2 + "."
            )
        }

    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.num1.length >= MAX_NUM_LENGHT) {
                return
            }
            state = state.copy(
                num1 = state.num1 + number
            )
            return
        }
        if (state.num2.length >= MAX_NUM_LENGHT) {
            return
        }
        state = state.copy(
            num2 = state.num2 + number
        )

    }

    companion object {
        private const val MAX_NUM_LENGHT = 8
    }
}

