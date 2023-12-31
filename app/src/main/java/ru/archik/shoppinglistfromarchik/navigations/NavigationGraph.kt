package ru.archik.shoppinglistfromarchik.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.archik.shoppinglistfromarchik.screens.aboutScreen.AboutListScreen
import ru.archik.shoppinglistfromarchik.screens.noteListScreen.NoteListScreen
import ru.archik.shoppinglistfromarchik.screens.settingsScreen.SettingsScreen
import ru.archik.shoppinglistfromarchik.screens.shoppingListScreen.ShoppingListScreen
import ru.archik.shoppinglistfromarchik.utils.Routes

@Composable
fun NavigationGraph(
  navController: NavHostController,
  onNavigate: (String) -> Unit
) {
  NavHost(
    navController = navController,
    startDestination = Routes.SHOPPING_LIST
  ) {
    composable(Routes.SHOPPING_LIST) {
      ShoppingListScreen() { route ->
        onNavigate(route)
      }
    }
    composable(Routes.NOTE_LIST) {
      NoteListScreen()
    }
    composable(Routes.ABOUT) {
      AboutListScreen()
    }
    composable(Routes.SETTINGS) {
      SettingsScreen()
    }
  }
}