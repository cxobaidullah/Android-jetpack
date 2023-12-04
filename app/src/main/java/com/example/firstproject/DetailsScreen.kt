package com.example.firstproject

import android.telecom.Call.Details
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.firstproject.DataClasses.Users


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details(navController: NavHostController? =null,users: String?=null){
    val user = Users(1, "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content")
    val initialUser = remember {
        mutableStateListOf(user)
    }
    Box(modifier = Modifier.fillMaxSize().background(Color.LightGray)){
//        UserCard(users = initialUser)
        Card(
            Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .wrapContentHeight()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(12.dp)
                    .padding(12.dp)


            ) {
                val painter = rememberImagePainter(data = R.drawable.profile)
                Image(
                    painter = painter,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                )
                Column(Modifier.padding(10.dp)) {
                    users?.let { Text(text = it) }

                    Button(onClick = {
                        //perfotm button action
//                        navController?.navigate("details/${user}")
//                    Toast.makeText(context,"Simplified Coding", Toast.LENGTH_LONG).show()

                    }) {
                        Text(text = stringResource(id = R.string.view_profile))
                    }
                }
            }
        }
        Button(
            modifier = Modifier
                .padding(24.dp)
                .align(alignment = Alignment.BottomCenter),
            onClick = {
                try {
//                    initialUser.add(user)
                    navController?.popBackStack()

                }catch (e:Exception){
                    Log.d("error","${e.message}")
                }

            }) {
            Text(text = "Go Back")
        }
    }
}
@Composable
fun UserCard(users: List<Users>){

    LazyColumn{
        items(users){user ->
            userListCard(user)

        }
    }
}
@Preview(showBackground = true)

@Composable
fun DefaultPreviewDetails() {

    Surface(modifier = Modifier.fillMaxSize()) {
//       Details()
    }


}