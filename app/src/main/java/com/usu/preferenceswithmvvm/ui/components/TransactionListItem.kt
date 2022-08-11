package com.usu.preferenceswithmvvm.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.usu.preferenceswithmvvm.ui.screens.Transaction

@Composable
fun TransactionListItem(transaction: Transaction, showPurpose: Boolean = true, showEntityName: Boolean = true, showEntityId: Boolean = true) {
    Spacer(modifier = Modifier.padding(4.dp))
    Surface(
        elevation = 2.dp,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(4.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "\$${transaction.amount}",
                    style = MaterialTheme.typography.h6
                )
                if (showEntityName) {
                    Text(text = transaction.entityName)
                }
            }
            if(showEntityId) {
                Text(
                    text = "${transaction.entityId}",
                    textAlign = TextAlign.Right,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            if (showPurpose) {
                Text(text = transaction.purpose)
            }
        }
    }
}