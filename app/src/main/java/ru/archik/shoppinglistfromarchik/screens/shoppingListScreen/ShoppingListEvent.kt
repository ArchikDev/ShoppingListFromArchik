package ru.archik.shoppinglistfromarchik.screens.shoppingListScreen

import ru.archik.shoppinglistfromarchik.data.entity.ShoppingListItem

sealed class ShoppingListEvent {
  data class OnShowDeleteDialog(val item: ShoppingListItem): ShoppingListEvent()
  data class OnShowEditDialog(val item: ShoppingListItem): ShoppingListEvent()
  data class OnItemClick(val route: String): ShoppingListEvent()
  object OnItemSave: ShoppingListEvent()
}
