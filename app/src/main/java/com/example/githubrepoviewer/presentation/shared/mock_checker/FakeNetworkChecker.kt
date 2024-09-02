package com.example.githubrepoviewer.presentation.shared.mock_checker

import com.example.githubrepoviewer.presentation.shared.network_checker.NetworkChecker

class FakeNetworkChecker(private var networkAvailable: Boolean) : NetworkChecker {
    override fun isNetworkAvailable(): Boolean = networkAvailable
}