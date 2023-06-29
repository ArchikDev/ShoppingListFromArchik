package ru.archik.shoppinglistfromarchik.screens.mainScreen

sealed class MainScreenEvent{
  object OnShowEditDialog: MainScreenEvent()
  object OnItemSave: MainScreenEvent()
//  data class Navigate(val route: String): MainScreenEvent()
//  data class NavigateMain(val route: String): MainScreenEvent()
//  data class OnNewItemClick(val route: String): MainScreenEvent()
}