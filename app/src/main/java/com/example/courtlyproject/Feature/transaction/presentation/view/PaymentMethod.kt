package com.example.courtlyproject.Feature.transaction.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.courtlyproject.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMethodsModal(navController: NavController) {
    val paymentMethods = listOf(
        PaymentMethod("BCA Mobile", "Saldo: Rp99.000.000", R.drawable.ic_bca),
        PaymentMethod("BNI Mobile Banking", "Saldo: Rp50.000", R.drawable.ic_bni),
        PaymentMethod("PayPal", "Saldo: Rp50.000", R.drawable.ic_paypal),
        PaymentMethod("GoPay", "Saldo: Rp30.000", R.drawable.ic_gopay),
        PaymentMethod("Dana", "Saldo: Rp30.000", R.drawable.ic_dana),
        PaymentMethod("Indomaret/i.saku", "Saldo: Rp-", R.drawable.ic_indomaret)
    )

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = { /* Handle dismiss */ },
        sheetState = sheetState,
        content = {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Pilih metode pembayaran",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                paymentMethods.forEach { method ->
                    PaymentMethodItem(method = method, navController)
                    Divider(modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    )
}



@Composable
fun PaymentMethodItem(method: PaymentMethod, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("detailpesanan")
            }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = method.iconRes),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = method.name, style = MaterialTheme.typography.bodyLarge)
            Text(text = method.balance, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
        }
    }
}

data class PaymentMethod(val name: String, val balance: String, val iconRes: Int)
