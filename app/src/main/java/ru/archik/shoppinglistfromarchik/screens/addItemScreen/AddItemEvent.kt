package ru.archik.shoppinglistfromarchik.screens.addItemScreen

import ru.archik.shoppinglistfromarchik.data.entity.AddItem

sealed class AddItemEvent {
  data class OnDelete(val item: AddItem): AddItemEvent()
  data class OnShowEditDialog(val item: AddItem): AddItemEvent()
  data class OnTextChange(val text: String): AddItemEvent()
  data class OnCheckedChange(val item: AddItem): AddItemEvent()
  object OnItemSave: AddItemEvent()
}
