package ru.archik.shoppinglistfromarchik.mainScreen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import ru.archik.shoppinglistfromarchik.ui.theme.BlueLight

@Composable
fun BottomNav() {
  val listItems = listOf(
    BottomNavItem.ListItem,
    BottomNavItem.NoteItem,
    BottomNavItem.AboutItem,
    BottomNavItem.SettingsItem
  )

  BottomNavigation(backgroundColor = Color.White) {
    listItems.forEach { item ->
      BottomNavigationItem(
        selected = false,
        onClick = { },
        icon = {
          Icon(
            painter = painterResource(id = item.iconId),
            contentDescription = item.title
          )
        },
        label = {
          Text(text = item.title)
        },
        selectedContentColor = BlueLight,
        unselectedContentColor = Color.Gray,
        alwaysShowLabel = false
      )
    }
  }

}