package com.example.newsappmvp.navigation



import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsappmvp.uiscreen.NewsApp


enum class NewsScreen {
    NewsList,
    NewsDetail
}

@Composable
fun NewsNavigation() {

  //  val newsViewModel: NewsViewModel = viewModel()

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NewsScreen.NewsList.name
    ) {

        composable(
            route = NewsScreen.NewsList.name
        ) {

            NewsApp(
//                vm = newsViewModel,
//
//                onNext = { articleUrl ->
//
//                    navController.navigate(
//                        "${NewsScreen.NewsDetail.name}/$articleUrl"
//                    )
//                }
            )
        }


    }
}