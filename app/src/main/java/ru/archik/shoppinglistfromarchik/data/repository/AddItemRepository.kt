package ru.archik.shoppinglistfromarchik.data.repository

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.archik.shoppinglistfromarchik.data.entity.AddItem
import ru.archik.shoppinglistfromarchik.data.entity.ShoppingListItem

interface AddItemRepository {
  suspend fun insertItem(item: AddItem)
  suspend fun deleteItem(item: AddItem)
  fun getAllItemsById(listId: Int): Flow<List<AddItem>>
  suspend fun getListItemById(listId: Int): ShoppingListItem
  suspend fun insertItem(item: ShoppingListItem)
}