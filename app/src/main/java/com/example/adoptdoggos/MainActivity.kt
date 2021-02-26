package com.example.adoptdoggos

import android.app.Activity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adoptdoggos.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!

@ExperimentalFoundationApi
@Composable
fun MyApp() {
    var selectedPuppy by remember { mutableStateOf<Puppy?>(null) }

    // HACK: Quick hacked together back catcher to navigate back from the puppy screen
    val context = LocalContext.current
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current
    val backCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (selectedPuppy != null) {
                    selectedPuppy = null
                } else {
                    (context as? Activity)?.finish()
                }
            }
        }
    }

    DisposableEffect(key1 = backDispatcher) {
        backDispatcher.onBackPressedDispatcher.addCallback(backCallback)
        onDispose {
            backCallback.remove()
        }
    }

    Surface(color = MaterialTheme.colors.background) {
        selectedPuppy?.let { puppy ->
            PuppyDetails(puppy = puppy)
        } ?: run {
            PuppyGrid {
                selectedPuppy = it
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun PuppyGrid(onPuppyClick: (Puppy) -> Unit) {
//
        val puppies = PuppyRepo.puppies
        LazyColumn{
            itemsIndexed(items=puppies){
                    _, puppy ->
                    PuppyView(puppy = puppy,modifier = Modifier
                            .fillMaxWidth()
                        .padding(bottom=6.dp,top=6.dp,start=6.dp,end=6.dp)
                            .clickable { onPuppyClick(puppy)})

            }


        }
    }


@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}