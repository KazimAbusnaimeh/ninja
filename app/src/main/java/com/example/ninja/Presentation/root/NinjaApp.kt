package com.example.patientreminderproject.ui.features

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.ninja.Presentation.navigation.NinjaNavGraph
import com.example.ninja.core.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NinjaRoot() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Ninja App")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MainColor
                )
            )
        },

        ) {
        Box(
            Modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            val navController = rememberNavController()
            NinjaNavGraph(navController)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    NinjaRoot()
}