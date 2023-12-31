package ru.archik.shoppinglistfromarchik.screens.shoppingListScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.archik.shoppinglistfromarchik.dialog.MainDialog
import ru.archik.shoppinglistfromarchik.ui.theme.GrayLight
import ru.archik.shoppinglistfromarchik.utils.UiEvent

@Composable
fun ShoppingListScreen(
  viewModel: ShoppingListViewModel = hiltViewModel(),
  onNavigate: (String) -> Unit
) {
  val itemsList = viewModel.list.collectAsState(initial = emptyList())

  // запустится один раз
  LaunchedEffect(key1 = true) {
    viewModel.uiEvent.collect { uiEven ->
      when(uiEven) {
        is UiEvent.Navigate -> {
          onNavigate(uiEven.route)
        }
        else -> {

        }
      }
    }
  }

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .background(GrayLight),
    contentPadding = PaddingValues(bottom = 100.dp)
  ) {
    items(itemsList.value) { item ->
      UiShoppingListItem(item) { it ->
        viewModel.onEvent(it)
      }
    }
  }
  MainDialog(viewModel)

  if(itemsList.value.isEmpty()) {
    Text(
      modifier = Modifier.fillMaxSize().wrapContentHeight(),
      text = "Empty",
      fontSize = 25.sp,
      textAlign = TextAlign.Center
    )
  }
}