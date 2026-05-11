package com.example.newsappmvp.uiscreen


import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsAppBar() {

    CenterAlignedTopAppBar(

        title = {

            Text(
                text = "News App",

                style = MaterialTheme.typography.titleLarge
            )
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(

            containerColor = Color(0xFFDC2626),

            titleContentColor = Color.White
        )
    )
}