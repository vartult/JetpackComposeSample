package com.an.jetpackcomposesample.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.an.jetpackcomposesample.ui.theme.Purple40
import com.an.jetpackcomposesample.ui.theme.Purple80

@Composable
fun SliderScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        TextHeading("Simple Slider")
        BasicSliderExample()

        TextHeading("Range Slider")
        RangeSliderExample()
    }
}

@Composable
fun BasicSliderExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = Purple40,
                activeTrackColor = Purple40,
                inactiveTrackColor = Purple80,
            ),
            steps = 5,
            valueRange = 0f..100f
        )
        Text(
            text = sliderPosition.toString(),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun RangeSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        RangeSlider(
            value = sliderPosition,
            steps = 5,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
            },
            colors = SliderDefaults.colors(
                thumbColor = Purple40,
                activeTrackColor = Purple40,
                inactiveTrackColor = Purple80,
            )
        )
        Text(
            text = sliderPosition.toString(),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}