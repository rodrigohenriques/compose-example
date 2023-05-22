package com.rodrigohenriques.compose.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rodrigohenriques.compose.example.ui.model.Contact
import com.rodrigohenriques.compose.example.ui.model.contacts
import com.rodrigohenriques.compose.example.ui.theme.CustomTheme

class ComposeFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return ComposeView(requireContext()).apply {
      setContent {
        CustomTheme {
          ContactsScreen(contacts = contacts)
        }
      }
    }
  }
}

@Composable
private fun ContactsScreen(contacts: List<Contact>) {
  LazyColumn {
    items(count = contacts.size, key = { index -> contacts[index].id }) { index ->
      val contact = contacts[index]

      ContactItem(
        name = contact.name,
        phone = contact.phone
      )
    }
  }
}

@Composable
fun ContactItem(name: String, phone: String) {
  Row(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
    Column(Modifier.weight(1f)) {
      Text(text = name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
      Text(text = phone, fontSize = 14.sp)
    }
    Icon(painter = painterResource(R.drawable.ic_chevron_right), contentDescription = "Forward")
  }
}

@Preview
@Composable
fun Preview() {
  CustomTheme {
    Surface {
      ContactsScreen(contacts = contacts)
    }
  }
}