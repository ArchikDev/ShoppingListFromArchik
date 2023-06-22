package ru.archik.shoppinglistfromarchik.screens.addItemScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddItemScreen() {
  Text(
    text="Add item screen",
    modifier = Modifier
      .fillMaxSize()
      .wrapContentWidth()
      .wrapContentHeight()
  )
}