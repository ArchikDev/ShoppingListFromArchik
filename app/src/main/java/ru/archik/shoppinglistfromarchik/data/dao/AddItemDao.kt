package ru.archik.shoppinglistfromarchik.data.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.archik.shoppinglistfromarchik.data.entity.AddItem
import ru.archik.shoppinglistfromarchik.data.entity.ShoppingListItem

@Dao
interface AddItemDao {
  // onConflict = OnConflictStrategy.REPLACE - если id уже есть то обновит запись
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertItem(item: AddItem)
  @Delete
  suspend fun deleteItem(item: AddItem)
  @Query("SELECT * FROM add_item WHERE listId = :listId")
  fun getAllItemsById(listId: Int): Flow<List<AddItem>>
  @Query("SELECT * FROM shop_list_item WHERE id = :listId")
  suspend fun getListItemById(listId: Int): ShoppingListItem
  @Update
  suspend fun insertItem(item: ShoppingListItem)
}