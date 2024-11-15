package com.paulinaaniola.plantkeeperv2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinaaniola.plantkeeperv2.R
import com.paulinaaniola.plantkeeperv2.model.Plant
import com.paulinaaniola.plantkeeperv2.model.PlantType
import kotlin.math.abs

@Composable
fun PlantItem(
    plantDTO: Plant,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(size = 15f)
    Column(
        modifier
            .padding(20.dp)
            .fillMaxWidth()
            .background(color = generateBackgroundColorFromTitle(plantDTO.plantName), shape = shape)
    ) {
        Text(modifier = Modifier.padding(5.dp), text = plantDTO.plantName)
        Text(
            modifier = Modifier.padding(5.dp),
            text = stringResource(
                R.string.plant_type, plantDTO.plantType.name
            )
        )
    }
}

@Composable
private fun generateBackgroundColorFromTitle(title: String): Color {
    val colors = listOf(
        MaterialTheme.colorScheme.secondaryContainer,
        MaterialTheme.colorScheme.tertiaryContainer,
        MaterialTheme.colorScheme.primaryContainer,
        MaterialTheme.colorScheme.inversePrimary,
        MaterialTheme.colorScheme.surfaceVariant,
        MaterialTheme.colorScheme.outlineVariant
    )
    return colors[abs(title.hashCode()) % colors.size]
}

@Preview(
    showBackground = true
)
@Composable
fun PlantItemPreview() {
    PlantItem(Plant(1, "Ficus", PlantType.PALM))
}

