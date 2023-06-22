package ru.archik.shoppinglistfromarchik.data.repository

import kotlinx.coroutines.flow.Flow
import ru.archik.shoppinglistfromarchik.data.dao.AddItemDao
import ru.archik.shoppinglistfromarchik.data.entity.AddItem
import ru.archik.shoppinglistfromarchik.data.entity.ShoppingListItem

class AddItemRepositoryImpl(
  private val dao: AddItemDao
) : AddItemRepository {
  override suspend fun insertItem(item: AddItem) {
    dao.insertItem(item)
  }

  override suspend fun insertItem(item: ShoppingListItem) {
    dao.insertItem(item)
  }

  override suspend fun deleteItem(item: AddItem) {
    dao.deleteItem(item)
  }

  override fun getAllItemsById(listId: Int): Flow<List<AddItem>> {
    return dao.getAllItemsById(listId)
  }

  override suspend fun getListItemById(listId: Int): ShoppingListItem {
    return dao.getListItemById(listId)
  }
}