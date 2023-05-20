package com.rodrigohenriques.compose.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.rodrigohenriques.compose.example.ui.theme.CustomTheme

class ChooseYourPathFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return ComposeView(requireContext()).apply {
      setContent {
        CustomTheme {
          Screen()
        }
      }
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  override fun onDestroyView() {
    super.onDestroyView()
  }
}

@Composable
private fun Screen() {
  Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
    Button(onClick = { /*TODO*/ }) {
      Text(text = "Legacy UI Toolkit")
    }

    Button(onClick = { /*TODO*/ }) {
      Text(text = "Compose UI Toolkit")
    }
  }
}

@Preview
@Composable
fun Screen_Preview() {
  CustomTheme {
    Screen()
  }
}