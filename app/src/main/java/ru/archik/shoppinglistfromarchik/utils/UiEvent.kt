package ru.archik.shoppinglistfromarchik.utils

sealed class UiEvent {
  object PopBackStack: UiEvent()
  data class Navigate(val route: String): UiEvent()
  data class SnowSnackBar(val message: String): UiEvent()
}
