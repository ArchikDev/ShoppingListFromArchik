package ru.archik.shoppinglistfromarchik.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.archik.shoppinglistfromarchik.data.MainDb
import ru.archik.shoppinglistfromarchik.data.repository.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // SingletonComponent - пока живёт приложение
object AppModule {
  @Provides
  @Singleton // Создаётся инстанс один раз
  fun provideMainDb(app: Application): MainDb {
    return Room.databaseBuilder(
      app,
      MainDb::class.java,
      "shop_list_db"
    ).build()
  }

  @Provides
  @Singleton // Создаётся инстанс один раз
  fun provideShopRepo(db: MainDb): ShoppingListRepository {
    return ShoppingListRepositoryImpl(db.shoppingListDao)
  }

  @Provides
  @Singleton // Создаётся инстанс один раз
  fun provideAddItemRepo(db: MainDb): AddItemRepository {
    return AddItemRepositoryImpl(db.addItemDao)
  }

  @Provides
  @Singleton // Создаётся инстанс один раз
  fun provideNoteItemRepo(db: MainDb): NoteRepository {
    return NoteRepositoryImpl(db.noteDao)
  }
}