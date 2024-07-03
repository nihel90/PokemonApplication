package com.example.mypokemonapplication.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import com.example.mypokemonapplication.presentation.view.composable.AutoCompleteSearchBar
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mypokemonapplication.R

@Composable
fun MainScreen() {

    val pokemons =
        listOf("bulbasaur", "ivysaur", "venusaur", "charmeleon", "charmander", "butterfree")
    val isUserTyping = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ) {
        AutoCompleteSearchBar(
            modifier = Modifier.fillMaxWidth(),
            items = pokemons,
            isUserTyping = isUserTyping,
            onSearchClicked = {
                println("search $it")
            },
        )

        if (isUserTyping.value.not()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)

                )
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        if (isUserTyping.value) {
                            Color.DarkGray
                        } else {
                            Color.White
                        }
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
                Icon(imageVector = Icons.AutoMirrored.Filled.List, contentDescription = null)
            }
        }
    }
}

@Preview(name = "MainScreen")
@Composable
fun MainScreenPreview() {
    MainScreen()
}