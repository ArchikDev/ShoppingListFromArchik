package ru.archik.shoppinglistfromarchik.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingListDao {
  // onConflict = OnConflictStrategy.REPLACE - если id уже есть то обновит запись
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertItem(item: ShoppingListItem)
  @Delete
  suspend fun deleteItem(item: ShoppingListItem)
  @Query("SELECT * FROM shop_list_item")
  suspend fun getAllItems(): Flow<List<ShoppingListItem>>
}