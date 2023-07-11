package ru.archik.shoppinglistfromarchik.data.repository

import kotlinx.coroutines.flow.Flow
import ru.archik.shoppinglistfromarchik.data.dao.ShoppingListDao
import ru.archik.shoppinglistfromarchik.data.entity.ShoppingListItem

class ShoppingListRepositoryImpl(
  private val dao: ShoppingListDao
): ShoppingListRepository {
  override suspend fun insertItem(item: ShoppingListItem) {
    dao.insertItem(item)
    // сюда можно еще, например, обращение к веб - сервису
  }

  override suspend fun deleteItem(item: ShoppingListItem) {
    dao.deleteShoppingList(item)
  }

  override fun getAllItems(): Flow<List<ShoppingListItem>> {
    return dao.getAllItems()
  }

}