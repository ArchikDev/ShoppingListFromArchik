package ru.archik.shoppinglistfromarchik.screens.addItemScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.archik.shoppinglistfromarchik.R
import ru.archik.shoppinglistfromarchik.dialog.MainDialog
import ru.archik.shoppinglistfromarchik.ui.theme.BlueLight
import ru.archik.shoppinglistfromarchik.ui.theme.DarkText
import ru.archik.shoppinglistfromarchik.ui.theme.GrayLight

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddItemScreen(
  viewModel: AddItemViewModel = hiltViewModel(),
) {
  val scaffoldState = rememberScaffoldState()
  val itemsList = viewModel.itemList?.collectAsState(initial = emptyList())

  Scaffold(scaffoldState = scaffoldState) {
    Column(modifier = Modifier
      .fillMaxSize()
      .background(GrayLight)) {
      Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          verticalAlignment = Alignment.CenterVertically
        ) {
          TextField(
            modifier = Modifier.weight(1f),
            value = viewModel.itemText.value,
            onValueChange = {
              viewModel.onEvent(AddItemEvent.OnTextChange(it))
            },
            label = {
              Text(
                text = "New Item",
                fontSize = 12.sp
              )
            },
            colors = TextFieldDefaults.textFieldColors(
              backgroundColor = Color.White,
              focusedIndicatorColor = BlueLight,
              unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle(
              fontSize = 16.sp,
              color = DarkText
            ),
            singleLine = true
          )
          IconButton(onClick = {
            viewModel.onEvent(AddItemEvent.OnItemSave)
          }) {
            Icon(
              painter = painterResource(id = R.drawable.ic_add),
              contentDescription = "Add"
            )
          }
        }
      }
      LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(
          top = 3.dp,
          start = 5.dp,
          end = 5.dp
        )
      ) {
        if (itemsList != null) {
          items(itemsList.value) {
            UiAddItem(item = it, onEvent = { event ->
              viewModel.onEvent(event)
            })
          }
        }
      }
    }
    MainDialog(dialogController = viewModel)

    if(itemsList?.value?.isEmpty() == true) {
      Text(
        modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Empty",
        fontSize = 25.sp,
        textAlign = TextAlign.Center
      )
    }
  }
}