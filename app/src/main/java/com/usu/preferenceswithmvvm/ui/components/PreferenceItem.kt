package com.usu.preferenceswithmvvm.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PreferenceItem(text: String, isChecked: Boolean, onChange: (newValue: Boolean) -> Unit) {
    Row(
        modifier = Modifier.padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
       Checkbox(checked = isChecked, onCheckedChange = onChange)
       Text(text = text)
    }
}