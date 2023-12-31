package ru.archik.shoppinglistfromarchik.screens.addItemScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.archik.shoppinglistfromarchik.R
import ru.archik.shoppinglistfromarchik.data.entity.AddItem

@Composable
fun UiAddItem(
  item: AddItem,
  onEvent: (AddItemEvent) -> Unit
) {
  Card(modifier = Modifier
    .fillMaxWidth()
    .padding(top = 3.dp)
    .clickable {
      onEvent(AddItemEvent.OnShowEditDialog(item))
    }
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        modifier = Modifier
          .weight(1f)
          .padding(10.dp),
        text = item.name,
        fontSize = 12.sp
      )
      Checkbox(
        checked = item.isCheck,
        onCheckedChange = {
          onEvent(AddItemEvent.OnCheckedChange(item.copy(isCheck = it)))
        }
      )
      IconButton(onClick = {
        onEvent(AddItemEvent.OnDelete(item))
      }) {
        Icon(
          painter = painterResource(
            id = R.drawable.ic_delete),
          contentDescription = "Delete"
        )
      }
    }
  }
}