package ru.archik.shoppinglistfromarchik.data.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.archik.shoppinglistfromarchik.data.entity.NoteItem

@Dao
interface NoteItemDao {
  // onConflict = OnConflictStrategy.REPLACE - если id уже есть то обновит запись
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertItem(item: NoteItem)
  @Delete
  suspend fun deleteItem(item: NoteItem)
  @Query("SELECT * FROM note_table")
  fun getAllItems(): Flow<List<NoteItem>>
  @Query("SELECT * FROM note_table WHERE id = :id")
  suspend fun getNoteItemById(id: Int): NoteItem
}