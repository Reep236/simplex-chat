package chat.simplex.app.views.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import chat.simplex.app.model.CIDirection
import chat.simplex.app.model.ChatItem
import chat.simplex.app.ui.theme.SimpleXTheme
import chat.simplex.app.views.chat.item.*
import kotlinx.datetime.Clock

@Composable
fun ContextItemView(
  contextItem: MutableState<ChatItem?>,
  editing: Boolean = false,
  resetMessage: () -> Unit = {}
) {
  val cxtItem = contextItem.value
  if (cxtItem != null) {
    val sent = cxtItem.chatDir.sent
    Row(
      Modifier
        .padding(top = 8.dp)
        .background(if (sent) SentColorLight else ReceivedColorLight),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        Modifier
          .padding(start = 16.dp)
          .padding(vertical = 12.dp)
          .fillMaxWidth()
          .weight(1F)
      ) {
        ContextItemText(cxtItem)
      }
      IconButton(onClick = {
        contextItem.value = null
        if (editing) {
          resetMessage()
        }
      }) {
        Icon(
          Icons.Outlined.Close,
          contentDescription = "Cancel",
          tint = MaterialTheme.colors.primary,
          modifier = Modifier.padding(10.dp)
        )
      }
    }
  }
}

@Composable
private fun ContextItemText(cxtItem: ChatItem) {
  val member = cxtItem.memberDisplayName
  if (member == null) {
    Text(cxtItem.content.text, maxLines = 3)
  } else {
    val annotatedText = buildAnnotatedString {
      withStyle(boldFont) { append(member) }
      append(": ${cxtItem.content.text}")
    }
    Text(annotatedText, maxLines = 3)
  }
}

@Preview
@Composable
fun PreviewContextItemView() {
  SimpleXTheme {
    ContextItemView(
      contextItem = remember {
        mutableStateOf(
          ChatItem.getSampleData(
            1, CIDirection.DirectRcv(), Clock.System.now(), "hello"
          )
        )
      }
    )
  }
}
