package ru.archik.shoppinglistfromarchik.screens.shoppingListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.archik.shoppinglistfromarchik.data.entity.ShoppingListItem
import ru.archik.shoppinglistfromarchik.data.repository.ShoppingListRepository
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
  private val repository: ShoppingListRepository
): ViewModel() {

  private var listItem: ShoppingListItem? = null

  fun onEvent(event: ShoppingListEvent) {
    when(event) {
      is ShoppingListEvent.OnItemSave -> {
        viewModelScope.launch {
          repository.insertItem(
            ShoppingListItem(
              listItem?.id,
              "List 1",
              "21-12-2023 13:00",
              listItem?.allItemsCount ?: 0,
              listItem?.allSelectedItemsCount ?: 0,
            )
          )
        }
      }
      is ShoppingListEvent.OnItemClick -> {}
      is ShoppingListEvent.OnShowEditDialog -> {
        listItem = event.item
      }
      is ShoppingListEvent.OnShowDeleteDialog -> {}
    }
  }

}