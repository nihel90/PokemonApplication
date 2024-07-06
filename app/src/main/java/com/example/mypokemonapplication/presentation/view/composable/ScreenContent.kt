package com.example.mypokemonapplication.presentation.view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import com.example.mypokemonapplication.R

private const val EMPTY_STRING = ""

@Composable
fun ScreenContent(
    modifier: Modifier = Modifier,
    toolbarTitle: String = EMPTY_STRING,
    toolbarIcon: Painter? = null,
    contentDescription: String? = null,
    hasToolbar: Boolean = true,
    onBackClicked: () -> (Unit) = {},
    content: @Composable (padding: PaddingValues) -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            if (hasToolbar) {
                ToolbarComponent(
                    backgroundColor = colorResource(
                        id = R.color.purple_500
                    ),
                    title = {
                        Text(text = toolbarTitle.uppercase())
                    },
                    icon = toolbarIcon,
                    contentDescription = contentDescription,
                    onBackClicked = onBackClicked,
                )
            }
        },
        content = content,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarComponent(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    icon: Painter? = null,
    contentDescription: String? = null,
    title: @Composable () -> Unit,
    onBackClicked: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier
            .statusBarsPadding()
            .background(color = backgroundColor),
        title = title,
        navigationIcon = {
            icon?.let {
                IconButton(
                    onClick = onBackClicked
                ) {
                    Icon(
                        painter = icon,
                        contentDescription = contentDescription
                    )
                }
            }
        }
    )
}