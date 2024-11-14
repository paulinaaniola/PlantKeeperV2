package com.paulinaaniola.plantkeeperv2.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.paulinaaniola.plantkeeperv2.R
import com.paulinaaniola.plantkeeperv2.ui.theme.PlantKeeperV2Theme

@ExperimentalMaterial3Api
@Composable
fun FormField(
    fieldValue: String,
    labelStringId: Int,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
    keyboardType: KeyboardType = KeyboardType.Text,
    isThereNextField: Boolean = false,
) {
    OutlinedTextField(
        modifier = modifier,
        value = fieldValue,
        onValueChange = onValueChange,
        label = { Text(text = stringResource(id = labelStringId)) },
        maxLines = maxLines,
        keyboardOptions = KeyboardOptions(
            imeAction = if (isThereNextField) ImeAction.Next else ImeAction.Default,
            keyboardType = keyboardType
        ),
        singleLine = maxLines == 1,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun FormFieldPreview() {
    PlantKeeperV2Theme {
        FormField(
            fieldValue = "",
            labelStringId = R.string.name,
            onValueChange = {}
        )
    }
}
