package ru.archik.shoppinglistfromarchik.screens.addItemScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
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

  init {
    val listId = savedStateHandle.get<String>("listId")?.toInt()

    itemList = listId?.let { repository.getAllItemsById(it) }
  }

  override var dialogTitle = mutableStateOf("")
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
        editTableText.value = ""
      }
      is DialogEvent.OnTextChange -> {
        editTableText.value = event.text
      }
    }
  }

  fun onEvent() {

  }

}