package com.geekpastor.quotesapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.geekpastor.quotesapp.ui.screen.MyScreen
import com.geekpastor.quotesapp.ui.theme.QuotesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesAppTheme {
                // A surface container using the 'background' color from the theme
                val viewModel : MainViewModel = hiltViewModel()
                    MyScreen(
                        onGetQuote = {
                            viewModel.getNotes()
                        },
                        uiState = viewModel.uiState.value
                    )
            }
        }
    }
}
