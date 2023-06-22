package ru.archik.shoppinglistfromarchik.data.repository

import kotlinx.coroutines.flow.Flow
import ru.archik.shoppinglistfromarchik.data.entity.ShoppingListItem

interface ShoppingListRepository {
  suspend fun insertItem(item: ShoppingListItem)
  suspend fun deleteItem(item: ShoppingListItem)
  fun getAllItems(): Flow<List<ShoppingListItem>>
}