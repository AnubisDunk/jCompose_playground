package com.anubisdunk.mvvm.calculator

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calculator(

) {
    val viewModel = viewModel<CalcViewModel>()
    val onAction = viewModel::onAction
    val state = viewModel.state
    Scaffold(
    ) {
        val ctx = LocalContext.current
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = state.num1 + (state.operation?.symbol ?: "") + state.num2,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    fontWeight = FontWeight.Light,
                    style = TextStyle(fontSize = 60.sp),
                    color = MaterialTheme.colorScheme.secondary,
                    maxLines = 2
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CalcButton(
                        symbol = "C",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(2f)
                            .weight(2f),
                        onClick = { onAction(CalculatorAction.Clear) }
                    )
                    CalcButton(
                        symbol = "Del",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Delete) }
                    )
                    CalcButton(
                        symbol = "/",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Div)) }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CalcButton(
                        symbol = "7",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorAction.Number(7))
                        }
                    )
                    CalcButton(
                        symbol = "8",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Number(8)) }
                    )
                    CalcButton(
                        symbol = "9",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Number(9)) }
                    )
                    CalcButton(
                        symbol = "*",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Mul)) }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CalcButton(
                        symbol = "4",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Number(4)) }
                    )
                    CalcButton(
                        symbol = "5",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Number(5)) }
                    )
                    CalcButton(
                        symbol = "6",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Number(6)) }
                    )
                    CalcButton(
                        symbol = "-",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Sub)) }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CalcButton(
                        symbol = "1",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Number(1)) }
                    )
                    CalcButton(
                        symbol = "2",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Number(2)) }
                    )
                    CalcButton(
                        symbol = "3",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Number(3)) }
                    )
                    CalcButton(
                        symbol = "+",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Operation(CalculatorOperation.Add)) }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CalcButton(
                        symbol = "0",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Number(0)) }
                    )
                    CalcButton(
                        symbol = ".",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Decimal) }
                    )
                    CalcButton(
                        symbol = "=",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onSecondaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onAction(CalculatorAction.Calculate) }
                    )
                    CalcButton(
                        symbol = "call",
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.onPrimaryContainer)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + state.num1))
                            ctx.startActivity(intent)

                        }
                    )
                }
            }
        }
    }
}





