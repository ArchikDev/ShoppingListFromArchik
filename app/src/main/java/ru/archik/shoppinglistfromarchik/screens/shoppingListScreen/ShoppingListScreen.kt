package ru.archik.shoppinglistfromarchik.screens.shoppingListScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ru.archik.shoppinglistfromarchik.dialog.MainDialog

@Composable
fun ShoppingListScreen(
  viewModel: ShoppingListViewModel = hiltViewModel()
) {
  Text(
    text="Shopping list screen",
    modifier = Modifier
      .fillMaxSize()
      .wrapContentWidth()
      .wrapContentHeight()
  )
  MainDialog(viewModel)
}