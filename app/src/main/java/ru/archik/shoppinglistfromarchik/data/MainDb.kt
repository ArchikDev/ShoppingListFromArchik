package ru.archik.shoppinglistfromarchik.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.archik.shoppinglistfromarchik.data.dao.AddItemDao
import ru.archik.shoppinglistfromarchik.data.dao.NoteItemDao
import ru.archik.shoppinglistfromarchik.data.dao.ShoppingListDao
import ru.archik.shoppinglistfromarchik.data.entity.AddItem
import ru.archik.shoppinglistfromarchik.data.entity.NoteItem
import ru.archik.shoppinglistfromarchik.data.entity.ShoppingListItem

@Database(
  entities = [ShoppingListItem::class, AddItem::class, NoteItem::class],
  version = 1
)
abstract class MainDb: RoomDatabase() {
  abstract val shoppingListDao: ShoppingListDao
  abstract val addItemDao: AddItemDao
  abstract val noteDao: NoteItemDao
}