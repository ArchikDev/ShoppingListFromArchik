package ru.archik.shoppinglistfromarchik.screens.mainScreen

import android.annotation.SuppressLint
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import ru.archik.shoppinglistfromarchik.R
import ru.archik.shoppinglistfromarchik.navigations.NavigationGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
  val navController = rememberNavController()

  Scaffold(
    bottomBar = {
      BottomNav(navController)
    },
    floatingActionButton = {
      FloatingActionButton(onClick = { }) {
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
  }

}