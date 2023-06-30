package ru.archik.shoppinglistfromarchik.screens.shoppingListScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import ru.archik.shoppinglistfromarchik.ui.theme.DarkText
import ru.archik.shoppinglistfromarchik.ui.theme.LightText
import ru.archik.shoppinglistfromarchik.R
import ru.archik.shoppinglistfromarchik.data.entity.ShoppingListItem
import ru.archik.shoppinglistfromarchik.ui.theme.GreenLight
import ru.archik.shoppinglistfromarchik.ui.theme.Red

@Composable
fun UiShoppingListItem(
  item: ShoppingListItem,
  onEvent: (ShoppingListEvent) -> Unit
) {
  ConstraintLayout(
    modifier = Modifier.padding(start = 3.dp, top = 18.dp, end = 3.dp)
  ) {
    val (card, deleteButton, editButton, counter) = createRefs()

    Card(
      modifier = Modifier
        .fillMaxWidth()
        .constrainAs(card) {
          top.linkTo(parent.top)
          start.linkTo(parent.start)
          end.linkTo(parent.end)
        }.clickable {  }
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(8.dp)
      ) {
        Text(
          text = item.name,
          style = TextStyle(
            color = DarkText,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
          )
        )
        Text(
          text = item.time,
          style = TextStyle(
            color = LightText,
            fontSize = 12.sp
          )
        )
        LinearProgressIndicator(
          modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
          progress = 0.5f
        )
      }
    }
    IconButton(
      onClick = {
        onEvent(ShoppingListEvent.OnShowDeleteDialog(item))
      },
      modifier = Modifier
        .constrainAs(deleteButton) {
          top.linkTo(card.top)
          bottom.linkTo(card.top)
          end.linkTo(card.end)
        }
        .padding(end = 10.dp)
        .size(30.dp)
    ) {
      Icon(
        painter = painterResource(id = R.drawable.ic_delete),
        contentDescription = "Delete",
        modifier = Modifier
          .clip(CircleShape)
          .background(Red)
          .padding(5.dp),
        tint = Color.White
      )
    }
    IconButton(
      onClick = {
        onEvent(ShoppingListEvent.OnShowEditDialog(item))
      },
      modifier = Modifier
        .constrainAs(editButton) {
          top.linkTo(card.top)
          bottom.linkTo(card.top)
          end.linkTo(deleteButton.start)
        }
        .padding(end = 5.dp)
        .size(30.dp)
    ) {
      Icon(
        painter = painterResource(id = R.drawable.ic_edit),
        contentDescription = "Edit",
        modifier = Modifier
          .clip(CircleShape)
          .background(GreenLight)
          .padding(5.dp),
        tint = Color.White
      )
    }
    Card(
      shape = RoundedCornerShape(5.dp),
      modifier = Modifier
        .constrainAs(counter) {
          top.linkTo(card.top)
          bottom.linkTo(card.top)
          end.linkTo(editButton.start)
        }
        .padding(end = 5.dp)
    ) {
      Text(
        text = "${item.allItemsCount}/${item.allSelectedItemsCount}",
        modifier = Modifier
          .background(Red)
          .padding(top = 3.dp, bottom = 3.dp, start = 5.dp, end = 5.dp),
        color = Color.White
      )
    }
  }
}