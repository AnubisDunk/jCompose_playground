package com.anubisdunk.mvvm.calculator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.sp

@Composable
fun CalcButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier)
    ){
        if(symbol != "call"){
            Text(
                text = symbol,
                fontSize = 36.sp,
                color = MaterialTheme.colorScheme.scrim
            )
        } else {
            Icon(
                imageVector = Icons.Filled.Call,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.scrim
            )
        }
    }
}

sealed class CalculatorAction {
    data class Number(val number : Int) : CalculatorAction()
    object Clear : CalculatorAction()
    object Delete : CalculatorAction()
    object Decimal : CalculatorAction()
    object Calculate : CalculatorAction()
    data class Operation(val operation: CalculatorOperation) : CalculatorAction()
}

sealed class CalculatorOperation(val symbol: String) {
    object Add: CalculatorOperation("+")
    object Sub: CalculatorOperation("-")
    object Mul: CalculatorOperation("*")
    object Div: CalculatorOperation("/")
}