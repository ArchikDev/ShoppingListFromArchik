package ru.archik.shoppinglistfromarchik.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_list_item")
data class ShoppingListItem(
  @PrimaryKey
  val id: Int? = null,
  val name: String,
  val time: String,
  val allItemsCount: Int,
  val allSelectedItemsCount: Int
)
