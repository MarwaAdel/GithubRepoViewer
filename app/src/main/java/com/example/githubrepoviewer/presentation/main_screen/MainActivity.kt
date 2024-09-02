package com.example.githubrepoviewer.presentation.main_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.githubrepoviewer.presentation.shared.navigation.MainNavigation
import com.example.githubrepoviewer.ui.theme.GithubRepoViewerTheme
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubRepoViewerTheme {
                val viewModel = getViewModel<MainViewModel>()
                send(viewModel)
                val navController = rememberNavController()
                MainNavigation(navController, viewModel)
            }
        }
    }

    // MVI pattern
    private fun send(viewModel: MainViewModel) {
        lifecycleScope.launch {
            viewModel.intentChannel.send(MainIntent.ReposList)
        }
    }
}
