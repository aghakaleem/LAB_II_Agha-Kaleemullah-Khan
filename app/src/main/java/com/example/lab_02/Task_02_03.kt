package com.example.lab_02

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Heroes_List() {
    val heroesNames = listOf("Iron Man", "Hulk", "Deadpool", "Wolverine", "Black Widow", "Thor")
    val heroesAges = listOf(45, 40, 35, 35, 35, 40)
    val heroesImages = listOf(
        R.drawable.ironman,
        R.drawable.hulk,
        R.drawable.deadpool,
        R.drawable.wolverine,
        R.drawable.blackwidow,
        R.drawable.thor
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
        ) {

        heroesNames.forEachIndexed { index, name ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(5.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color.Gray),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,


                        ) {
                        Image(
                            painter = painterResource(id = heroesImages[index]),
                            contentDescription = heroesNames[index],
                            modifier = Modifier
                                .padding(15.dp)
                                .size(80.dp, 80.dp),
                            contentScale = ContentScale.Fit
                        )

                        Column {
                            Text(
                                text = heroesNames[index],
                                fontSize = 30.sp,
                                fontWeight = FontWeight.W700
                            )

                            Text(
                                text = "Age: ${heroesAges[index]}",
                                fontSize = 20.sp,
                                modifier = Modifier.alpha(0.7f),
                                fontWeight = FontWeight.W400
                            )
                        }
                    }
                }
            }
        }

    }

}