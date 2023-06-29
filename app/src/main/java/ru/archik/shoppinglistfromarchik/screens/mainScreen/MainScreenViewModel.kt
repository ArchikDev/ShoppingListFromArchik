package ru.archik.shoppinglistfromarchik.screens.mainScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.archik.shoppinglistfromarchik.data.entity.ShoppingListItem
import ru.archik.shoppinglistfromarchik.data.repository.ShoppingListRepository
import ru.archik.shoppinglistfromarchik.dialog.DialogController
import ru.archik.shoppinglistfromarchik.dialog.DialogEvent
import ru.archik.shoppinglistfromarchik.screens.shoppingListScreen.ShoppingListEvent
import ru.archik.shoppinglistfromarchik.utils.UiEvent
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(
  private val repository: ShoppingListRepository
): ViewModel(), DialogController {

  override var dialogTitle = mutableStateOf("List name:")
    private set

  override var editTableText = mutableStateOf("")
    private set

  override var openDialog = mutableStateOf(false)
    private set

  override var showEditTableText = mutableStateOf(true)
    private set

  fun onEvent(event: MainScreenEvent) {
    when(event) {
      is MainScreenEvent.OnItemSave -> {
        if (editTableText.value.isEmpty()) return

        viewModelScope.launch {
          repository.insertItem(
            ShoppingListItem(
              null,
              editTableText.value,
              "21-12-2023 13:00",
              0,
              0,
            )
          )
        }
      }
      is MainScreenEvent.OnShowEditDialog -> {
        openDialog.value = true
      }
    }
  }

  override fun onDialogEvent(event: DialogEvent) {
    when(event) {
      is DialogEvent.OnCancel -> {
        openDialog.value = false
      }
      is DialogEvent.OnConfirm -> {
        onEvent(MainScreenEvent.OnItemSave)
        openDialog.value = false
      }
      is DialogEvent.OnTextChange -> {
        editTableText.value = event.text
      }
    }
  }

}