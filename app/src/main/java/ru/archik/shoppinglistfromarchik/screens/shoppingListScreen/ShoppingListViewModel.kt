package ru.archik.shoppinglistfromarchik.screens.shoppingListScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.archik.shoppinglistfromarchik.data.entity.ShoppingListItem
import ru.archik.shoppinglistfromarchik.data.repository.ShoppingListRepository
import ru.archik.shoppinglistfromarchik.dialog.DialogEvent
import ru.archik.shoppinglistfromarchik.dialog.DialogController
import ru.archik.shoppinglistfromarchik.utils.UiEvent
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
  private val repository: ShoppingListRepository
): ViewModel(), DialogController {

  val list = repository.getAllItems()

  private val _uiEvent = Channel<UiEvent>()
  val uiEvent = _uiEvent.receiveAsFlow()

  private var listItem: ShoppingListItem? = null

  override var dialogTitle = mutableStateOf("")
    private set

  override var editTableText = mutableStateOf("")
    private set

  override var openDialog = mutableStateOf(false)
    private set

  override var showEditTableText = mutableStateOf(false)
    private set


  fun onEvent(event: ShoppingListEvent) {
    when(event) {
      is ShoppingListEvent.OnItemSave -> {
        if (editTableText.value.isEmpty()) return
        viewModelScope.launch {
          repository.insertItem(
            ShoppingListItem(
              listItem?.id,
              editTableText.value,
              "21-12-2023 13:00",
              listItem?.allItemsCount ?: 0,
              listItem?.allSelectedItemsCount ?: 0,
            )
          )
        }
      }
      is ShoppingListEvent.OnItemClick -> {
        sendUiEvent(UiEvent.Navigate(event.route))
      }
      is ShoppingListEvent.OnShowEditDialog -> {
        listItem = event.item
        openDialog.value = true
        editTableText.value = listItem?.name ?: ""
        dialogTitle.value = "List name: "
        showEditTableText.value = true
      }
      is ShoppingListEvent.OnShowDeleteDialog -> {
        listItem = event.item
        openDialog.value = true
        dialogTitle.value = "Delete this item?"
        showEditTableText.value = false
      }
    }
  }

  override fun onDialogEvent(event: DialogEvent) {
    when(event) {
      is DialogEvent.OnCancel -> {
        openDialog.value = false
      }
      is DialogEvent.OnConfirm -> {
        if (showEditTableText.value) {
          onEvent(ShoppingListEvent.OnItemSave)
        } else {
          viewModelScope.launch {
            listItem?.let { repository.deleteItem(it) }
          }
        }
        openDialog.value = false
      }
      is DialogEvent.OnTextChange -> {
        editTableText.value = event.text
      }
    }
  }

  private fun sendUiEvent(event: UiEvent) {
    viewModelScope.launch {
      _uiEvent.send(event)
    }
  }
}