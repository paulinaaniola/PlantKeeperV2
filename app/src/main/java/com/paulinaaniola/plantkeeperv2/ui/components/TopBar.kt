package com.paulinaaniola.plantkeeperv2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(topBarText: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .height(80.dp),
    ) {
        Text(
            text = topBarText,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(10.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun TopBarPreview() {
    TopBar("My Plants")
}
