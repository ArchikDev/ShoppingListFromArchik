package ru.archik.shoppinglistfromarchik.data.repository

import kotlinx.coroutines.flow.Flow
import ru.archik.shoppinglistfromarchik.data.entity.NoteItem

interface NoteRepository {
  suspend fun insertItem(item: NoteItem)
  suspend fun deleteItem(item: NoteItem)
  fun getAllItems(): Flow<List<NoteItem>>
  suspend fun getNoteItemById(id: Int): NoteItem
}