package ru.archik.shoppinglistfromarchik.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.archik.shoppinglistfromarchik.screens.aboutScreen.AboutListScreen
import ru.archik.shoppinglistfromarchik.screens.addItemScreen.AddItemScreen
import ru.archik.shoppinglistfromarchik.screens.mainScreen.MainScreen
import ru.archik.shoppinglistfromarchik.screens.newNoteScreen.NewNoteScreen
import ru.archik.shoppinglistfromarchik.screens.noteListScreen.NoteListScreen
import ru.archik.shoppinglistfromarchik.screens.settingsScreen.SettingsScreen
import ru.archik.shoppinglistfromarchik.screens.shoppingListScreen.ShoppingListScreen
import ru.archik.shoppinglistfromarchik.utils.Routes

@Composable
fun MainNavigationGraph() {

  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = Routes.MAIN
  ) {
    composable(Routes.ADD_ITEM + "/{listId}") {
      AddItemScreen()
    }
    composable(Routes.NEW_NOTE) {
      NewNoteScreen()
    }
    composable(Routes.MAIN) {
      MainScreen(navController)
    }
  }
}