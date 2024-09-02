package com.example.githubrepoviewer.di

import androidx.room.Room
import com.example.githubrepoviewer.core.RetrofitHelper
import com.example.githubrepoviewer.network.local_network.AppDatabase
import com.example.githubrepoviewer.network.local_network.GithubRepository
import com.example.githubrepoviewer.network.local_network.IGithubRepository
import com.example.githubrepoviewer.network.mock.FakeGithubRepository
import com.example.githubrepoviewer.network.remote_network.ApiCall
import com.example.githubrepoviewer.network.remote_network.IApiCall
import com.example.githubrepoviewer.network.remote_network.MainApiRepoImp
import com.example.githubrepoviewer.presentation.details_screen.DetailsVm
import com.example.githubrepoviewer.presentation.issues_screen.IssuesVm
import com.example.githubrepoviewer.presentation.main_screen.MainViewModel
import com.example.githubrepoviewer.presentation.shared.network_checker.NetworkChecker
import com.example.githubrepoviewer.presentation.shared.network_checker.RealNetworkChecker
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        RetrofitHelper.createService(ApiConfig.BASE_URL.url, ApiCall::class.java)
    }
    single<IApiCall> {
        MainApiRepoImp(get())
    }
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, DatabaseConfig.DB_NAME.dbName)
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().githubDao() }

    single<IGithubRepository> { GithubRepository(get()) }
    single { FakeGithubRepository() }
    single<NetworkChecker> { RealNetworkChecker(androidContext()) }
    viewModel {
        MainViewModel(get(), get(), get())
    }
    viewModel {
        DetailsVm(get(), get(), get())
    }
    viewModel {
        IssuesVm(get(), get(),get())
    }
}