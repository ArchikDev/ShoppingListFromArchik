package ru.archik.shoppinglistfromarchik.screens.addItemScreen

import ru.archik.shoppinglistfromarchik.data.entity.AddItem

sealed class AddItemEvent {
  data class onDelete(val item: AddItem): AddItemEvent()
  data class onShowEditDialog(val item: AddItem): AddItemEvent()
  data class onTextChange(val text: String): AddItemEvent()
  data class onCheckedChange(val item: AddItem): AddItemEvent()
  object OnItemSave: AddItemEvent()
}
