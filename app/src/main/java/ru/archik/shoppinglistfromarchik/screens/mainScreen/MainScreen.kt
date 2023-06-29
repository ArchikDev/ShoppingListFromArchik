package ru.archik.shoppinglistfromarchik.screens.mainScreen

import android.annotation.SuppressLint
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import ru.archik.shoppinglistfromarchik.R
import ru.archik.shoppinglistfromarchik.dialog.MainDialog
import ru.archik.shoppinglistfromarchik.navigations.NavigationGraph
import ru.archik.shoppinglistfromarchik.screens.shoppingListScreen.ShoppingListViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
  viewModel: MainScreenViewModel = hiltViewModel()
) {
  val navController = rememberNavController()

  Scaffold(
    bottomBar = {
      BottomNav(navController)
    },
    floatingActionButton = {
      FloatingActionButton(onClick = {
        viewModel.onEvent(MainScreenEvent.OnShowEditDialog)
      }) {
        Icon(
          painter = painterResource(id = R.drawable.ic_add),
          contentDescription = "add",
          tint = Color.White
        )
      }
    },
    floatingActionButtonPosition = FabPosition.Center,
    isFloatingActionButtonDocked = true
  ) {
    NavigationGraph(navController)
    MainDialog(viewModel)
  }

}