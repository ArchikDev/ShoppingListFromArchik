package ru.archik.shoppinglistfromarchik.data.repository

import kotlinx.coroutines.flow.Flow
import ru.archik.shoppinglistfromarchik.data.dao.NoteItemDao
import ru.archik.shoppinglistfromarchik.data.entity.NoteItem

class NoteRepositoryImpl(
  private val dao: NoteItemDao
) : NoteRepository {
  override suspend fun insertItem(item: NoteItem) {
    dao.insertItem(item)
  }

  override suspend fun deleteItem(item: NoteItem) {
    dao.deleteItem(item)
  }

  override fun getAllItems(): Flow<List<NoteItem>> {
    return dao.getAllItems()
  }

  override suspend fun getNoteItemById(id: Int): NoteItem {
    return dao.getNoteItemById(id)
  }

}