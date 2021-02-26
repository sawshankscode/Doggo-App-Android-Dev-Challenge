package com.example.adoptdoggos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adoptdoggos.ui.theme.MyTheme


@Composable
fun PuppyView(puppy: Puppy, modifier: Modifier = Modifier) {
    Card( modifier, shape = RoundedCornerShape(16.dp),elevation = 8.dp) {
        Column{

            Image(
                painterResource(puppy.resId),
                null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(225.dp),
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier.padding(top =12.dp,bottom= 12.dp ,start = 8.dp,end= 8.dp)) {
                Text(text = puppy.name, modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h5)

                }
            }





    }
}

@Preview
@Composable
private fun PuppyPreview() {
    MyTheme {
        PuppyView(puppy = PuppyRepo.puppies.first())
    }
}