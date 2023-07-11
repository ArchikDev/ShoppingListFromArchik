package ru.archik.shoppinglistfromarchik.data.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.archik.shoppinglistfromarchik.data.entity.ShoppingListItem

@Dao
interface ShoppingListDao {
  // onConflict = OnConflictStrategy.REPLACE - если id уже есть то обновит запись
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertItem(item: ShoppingListItem)
  @Delete
  suspend fun deleteItem(item: ShoppingListItem)
  @Query("DELETE FROM add_item WHERE listId = :listId")
  fun deleteAddItems(listId: Int)
  @Query("SELECT * FROM shop_list_item")
  fun getAllItems(): Flow<List<ShoppingListItem>>
  @Transaction
  suspend fun deleteShoppingList(item: ShoppingListItem) {
    deleteAddItems(item.id!!)
    deleteItem(item)
  }
}