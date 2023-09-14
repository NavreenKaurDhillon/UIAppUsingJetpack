package com.example.myuiapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myuiapp.ui.theme.MyUiAppTheme
import com.example.myuiapp.ui.theme.Purple80
import com.example.myuiapp.ui.theme.models.Review

//compose - built to support material design principles
//support material design 3 widgets for styling
class MainActivity : ComponentActivity() {
val reviews = ArrayList<Review>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            //enclose in MyUiAppTheme - so UI funtions can inherit styles,etc. from app theme -> consistency across app
            MyUiAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    Column(modifier = Modifier.fillMaxSize()) {
                        //Text - composable function used to display simple text onto screen
                        Text(text = "text box")

                        //call to see in app build - for now just previewed
                        //       Greeting("Android")

                        val review1 = Review("Navreen", " Good")
                        displayReview(review1)
                        shapeViews()

                    }
                }
            }
        }
    }

    @Composable
    private fun displayReview(review1: Review) {
        //@Row - align items horizontally
        //@Column - vertically
        //@Box - stack items

        Column {
            Text(text = review1.reviwerName)
            Text(text = review1.message)

            //Spacer - add space in the UI
            Spacer(
                modifier = Modifier
                    .size(20.dp))
            //Modifiers - configure or modify composables
            Row {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_launcher_background
                    ),
                    contentDescription = R.string.app_name.toString(),
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape))

                Spacer(modifier = Modifier.size(5.dp))
                Text(text = review1.reviwerName)
                Text(text = review1.message)
            }
        }

    }

    @Preview //needs to be added before composable or causes error
    @Composable
    private fun displayReviewSeconday() {
        MyUiAppTheme {
            Surface {
                displayReview(Review("Harsh", " Bad"))
            }
        }
    }


    //@Composable - make a user defined function composable
    //this function cannot be previewed directly - take param
    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = "wallpaper image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp)
            )
            Column {
                Text(
                    text = "Hello world",
                    modifier = modifier
                        .padding(12.dp, 0.dp)
                )
                Text(
                    text = " $name",
                    modifier = modifier
                        .padding(12.dp, 0.dp)
                )
            }
        }
    }

    //@Preview - preview the function result without need to build and installed,
    // can be used only with functions that donot take any paramters
    //this is secondary function to preview Greeting function
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyUiAppTheme {
            Greeting("Android 2")
        }
    }

    //Material Design is built around three pillars: Color, Typography, and Shape.

    //1.Using Color
    @Composable
    fun showColoredText() {
        Column {
            Text(
                text = "Pink colored text",
                color = Color.Magenta,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(5.0f, 8.0f),
                        blurRadius = 3f
                    )
                )
            )
            Text(
                text = stringResource(id = R.string.red_text),
                color = Color.Red,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Medium,
            )
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Light))
                    {
                        append("hello ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.teal_200),
                            fontFamily = FontFamily.Cursive
                        )
                    )
                    {
                        append(" hello")
                    }
                })

            val gradientColors = listOf(Cyan, Blue, Purple80)

            Text(
                text = "texttexttexttexttexttext\ntexttexttexttexttexttext\ntexttexttexttexttexttext",
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = gradientColors
                    )))
        }
    }

    //2.shape - used to give background shape
    @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true)
    @Composable
    fun shapeViews() {

        reviews.add(Review("Navreen", "Good"))
        reviews.add(Review("Harsh", "Bad"))
        reviews.add(Review("Ria", "very bad"))

        Column {
        Surface(
            shape = MaterialTheme.shapes.medium,
            shadowElevation = 1.dp,

            ) {
            Text(
                text = "msg.body\ngg\ntg",
                modifier = Modifier.padding(all = 4.dp),
                style = MaterialTheme.typography.titleLarge
            )
        }
            displayReviews(reviews = reviews)
        }
    }


    @Composable
    fun displayReviews(reviews : ArrayList<Review>) {
        LazyColumn{
            items(reviews){it ->
                Spacer(modifier = Modifier.size(10.dp))

                Surface(shape = MaterialTheme.shapes.medium,
                    shadowElevation = 1.dp,
                    color = MaterialTheme.colorScheme.primary) {

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .border(3.dp, Magenta)
                        .padding(8.dp)) {

                        Text(text = "Review by: ${it.reviwerName}",
                            modifier = Modifier.fillMaxWidth().padding(4.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge)
                        Text(
                            text = "Review = ${it.message}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }
        }
       
    }
}


