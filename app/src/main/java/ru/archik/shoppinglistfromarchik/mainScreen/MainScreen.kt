package ru.archik.shoppinglistfromarchik.mainScreen

import android.annotation.SuppressLint
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import ru.archik.shoppinglistfromarchik.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
  Scaffold(
    bottomBar = {
      BottomNav()
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

  }

}