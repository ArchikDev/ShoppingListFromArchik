package ru.archik.shoppinglistfromarchik.screens.addItemScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.archik.shoppinglistfromarchik.data.entity.AddItem
import ru.archik.shoppinglistfromarchik.data.repository.AddItemRepository
import ru.archik.shoppinglistfromarchik.dialog.DialogController
import ru.archik.shoppinglistfromarchik.dialog.DialogEvent
import javax.inject.Inject

@HiltViewModel
class AddItemViewModel @Inject constructor(
  private val repository: AddItemRepository,
  savedStateHandle: SavedStateHandle
): ViewModel(), DialogController {

  var itemList: Flow<List<AddItem>>? = null
  var addItem: AddItem? = null
  var listId: Int = -1

  init {
    listId = savedStateHandle.get<String>("listId")?.toInt()!!

    itemList = listId.let { repository.getAllItemsById(it) }
  }

  var itemText = mutableStateOf("")
    private set

  override var dialogTitle = mutableStateOf("Edit name:")
    private set

  override var editTableText = mutableStateOf("")
    private set

  override var openDialog = mutableStateOf(false)
    private set

  override var showEditTableText = mutableStateOf(true)
    private set

  override fun onDialogEvent(event: DialogEvent) {
    when(event) {
      is DialogEvent.OnCancel -> {
        openDialog.value = false
        editTableText.value = ""
      }
      is DialogEvent.OnConfirm -> {
        openDialog.value = false
        itemText.value = editTableText.value
        editTableText.value = ""
      }
      is DialogEvent.OnTextChange -> {
        editTableText.value = event.text
      }
    }
  }

  fun onEvent(event: AddItemEvent) {
    when(event) {
      is AddItemEvent.OnItemSave -> {
        if (listId == -1) return
        viewModelScope.launch {
          repository.insertItem(
            AddItem(
              addItem?.id,
              itemText.value,
              addItem?.isCheck ?: false,
              listId
            )
          )

          itemText.value = ""
          addItem = null
        }
      }
      is AddItemEvent.OnShowEditDialog -> {
        addItem = event.item
        openDialog.value = true
        editTableText.value = addItem?.name ?: ""
      }
      is AddItemEvent.OnTextChange -> {
        itemText.value = event.text
      }
      is AddItemEvent.OnDelete -> {
        viewModelScope.launch {
          repository.deleteItem(event.item)
        }
      }
      is AddItemEvent.OnCheckedChange -> {
        viewModelScope.launch {
          repository.insertItem(event.item)
        }
      }
    }
  }

}