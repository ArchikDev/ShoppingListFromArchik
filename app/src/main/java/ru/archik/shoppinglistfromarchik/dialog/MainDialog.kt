package ru.archik.shoppinglistfromarchik.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.archik.shoppinglistfromarchik.ui.theme.DarkText
import ru.archik.shoppinglistfromarchik.ui.theme.GrayLight

@Composable
fun MainDialog(
  dialogController: DialogController
) {
  if (dialogController.openDialog.value) {
    AlertDialog(
      onDismissRequest = {
        dialogController.onDialogEvent(DialogEvent.OnCancel)
      },
      title = null,
      text = {
        Column(modifier = Modifier.fillMaxWidth()) {
          Text(
            text = dialogController.dialogTitle.value,
            style = TextStyle(
              color = DarkText,
              fontWeight = FontWeight.Bold,
              fontSize = 20.sp
            )
          )
          Spacer(modifier = Modifier.height(10.dp))
          if (dialogController.showEditTableText.value) {
            TextField(
              value = dialogController.editTableText.value,
              onValueChange = {
                dialogController.onDialogEvent(DialogEvent.OnTextChange(it))
              },
              label = {
                Text(text = "List name:")
              },
              colors = TextFieldDefaults.textFieldColors(
                backgroundColor = GrayLight,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
              ),
              shape = RoundedCornerShape(8.dp),
              textStyle = TextStyle(
                color = DarkText,
                fontSize = 16.sp
              ),
              singleLine = true
            )
          }
        }
      },
      confirmButton = {
        TextButton(onClick = {
          dialogController.onDialogEvent(DialogEvent.OnConfirm)
        }) {
          Text(text = "OK")
        }
      },
      dismissButton = {
        TextButton(onClick = {
          dialogController.onDialogEvent(DialogEvent.OnCancel)
        }) {
          Text(text = "Cancel")
        }
      }
    )
  }
}