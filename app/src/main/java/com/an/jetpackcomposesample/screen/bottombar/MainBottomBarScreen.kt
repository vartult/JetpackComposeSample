package com.an.jetpackcomposesample.screen.bottombar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.an.jetpackcomposesample.provider.Navigation
import com.an.jetpackcomposesample.ui.theme.Purple40
import com.an.jetpackcomposesample.ui.theme.PurpleGrey80

@Composable
fun MainBottomBarScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Scaffold (
        bottomBar = {
            BottomAppBar(
                containerColor = PurpleGrey80,
                contentColor = Purple40,
            ) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        Box(
            modifier = modifier.padding(
                PaddingValues(
                    0.dp,
                    0.dp,
                    0.dp,
                    innerPadding.calculateBottomPadding()
                )
            )
        ) {
            Navigation(navController = navController)
        }
    }
}