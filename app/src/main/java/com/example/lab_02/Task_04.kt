package com.example.lab_02

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * This function is a Composable function that creates a Lazy Grid Layout.
 * It uses the ExperimentalMaterial3Api to create a Scaffold with a TopAppBar and a LazyVerticalStaggeredGrid.
 * The grid displays a list of heroes with their images.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyGridLayout() {

    // List of hero names
    val heroesNames = listOf("Iron Man", "Hulk", "Deadpool", "Wolverine", "Black Widow", "Thor")
    // List of hero images
    val heroesImages = listOf(
        R.drawable.ironman,
        R.drawable.hulk,
        R.drawable.deadpool,
        R.drawable.wolverine,
        R.drawable.blackwidow,
        R.drawable.thor
    )

    // Scaffold is a Material Design container for other components
    Scaffold(
        // TopAppBar is a container for top app bar content
        topBar = {
            TopAppBar(
                // Title of the TopAppBar
                title = { Text(text = "Lazy Grid Layout", fontSize = 20.sp) },
                // Colors for the TopAppBar
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500),
                    titleContentColor = colorResource(id = R.color.white)
                )
            )
        },
        // Content of the Scaffold
        content = {
            // LazyVerticalStaggeredGrid is a vertically scrolling list that only composes and lays out the items currently visible
            LazyVerticalStaggeredGrid(
                // Number of columns in the grid
                columns = StaggeredGridCells.Adaptive(150.dp),
                // Vertical spacing between items
                verticalItemSpacing = 4.dp,
                // Horizontal arrangement of items
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                // Modifier for the grid
                modifier = Modifier.padding(it).fillMaxSize(),
                // Content of the grid
                content = {
                    // For each hero, create a Card with an Image and a Text
                    items(heroesNames.count()) { index ->
                        Card (
                            // Shape of the Card
                            shape = RoundedCornerShape(0.dp),
                            // Modifier for the Card
                            modifier = Modifier
                                .padding(5.dp)
                        ){
                            // Image of the hero
                            Image(
                                painter = painterResource(id = heroesImages[index]),
                                contentDescription = "Photo of ${heroesNames[index]}",
                                modifier = Modifier
                                    .size(200.dp)
                                    .padding(10.dp),

                                )
                            // Name of the hero
                            Text(
                                text = heroesNames[index],
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.background(Color.Blue).fillMaxWidth().padding(5.dp),
                                color = Color.White)
                        }
                    }
                },
            )
        }
    )
}