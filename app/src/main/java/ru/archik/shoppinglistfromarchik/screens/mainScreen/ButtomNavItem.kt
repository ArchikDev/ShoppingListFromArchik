package ru.archik.shoppinglistfromarchik.screens.mainScreen

import ru.archik.shoppinglistfromarchik.R
import ru.archik.shoppinglistfromarchik.utils.Routes

sealed class BottomNavItem(
  val title: String,
  val iconId: Int,
  val route: String
) {
  object ListItem: BottomNavItem("List", R.drawable.ic_add, Routes.SHOPPING_LIST)
  object NoteItem: BottomNavItem("Note", R.drawable.ic_note, Routes.NOTE_LIST)
  object AboutItem: BottomNavItem("About", R.drawable.ic_about, Routes.ABOUT)
  object SettingsItem: BottomNavItem("Settings", R.drawable.ic_settings, Routes.SETTINGS)
}
