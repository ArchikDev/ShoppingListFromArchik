package ru.archik.shoppinglistfromarchik.screens.mainScreen

import ru.archik.shoppinglistfromarchik.R

sealed class BottomNavItem(
  val title: String,
  val iconId: Int,
  val route: String
) {
  object ListItem: BottomNavItem("List", R.drawable.ic_add, "route1")
  object NoteItem: BottomNavItem("Note", R.drawable.ic_note, "route2")
  object AboutItem: BottomNavItem("About", R.drawable.ic_about, "route3")
  object SettingsItem: BottomNavItem("Settings", R.drawable.ic_settings, "route4")
}
