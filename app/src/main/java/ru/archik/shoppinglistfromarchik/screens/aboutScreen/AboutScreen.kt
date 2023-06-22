package ru.archik.shoppinglistfromarchik.screens.aboutScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AboutListScreen() {
  Text(
    text="About screen",
    modifier = Modifier
      .fillMaxSize()
      .wrapContentWidth()
      .wrapContentHeight()
  )
}