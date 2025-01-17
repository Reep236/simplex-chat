package chat.simplex.app.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleButton(text: String, icon: ImageVector,
                 color: Color = MaterialTheme.colors.primary,
                 click: () -> Unit) {
  Row(
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.clickable { click() }
  ) {
    Icon(icon, text, tint = color,
      modifier = Modifier.padding(horizontal = 10.dp)
    )
    Text(text, style = MaterialTheme.typography.caption,  color = color)
  }
}

@Preview
@Composable
fun PreviewCloseSheetBar() {
  SimpleXTheme {
    SimpleButton(text = "Share", icon = Icons.Outlined.Share, click = {})
  }
}
