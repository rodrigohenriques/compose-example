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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rodrigohenriques.compose.example.ui.theme.CustomTheme

class ChooseYourPathFragment : Fragment() {
  private val navController by lazy { findNavController() }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return ComposeView(requireContext()).apply {
      setContent {
        CustomTheme {
          Screen(
            goToLegacyViews = {
              navController.navigate(ChooseYourPathFragmentDirections.actionOpenLegacyViews())
            }
          )
        }
      }
    }
  }
}

@Composable
private fun Screen(goToLegacyViews: () -> Unit = {}, goToCompose: () -> Unit = {}) {
  Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
    Button(onClick = goToLegacyViews) {
      Text(text = stringResource(id = R.string.legacy_views_label))
    }

    Button(onClick = goToCompose) {
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