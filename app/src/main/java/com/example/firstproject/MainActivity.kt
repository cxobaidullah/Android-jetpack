package com.example.firstproject

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstproject.DataClasses.Users
import com.example.firstproject.DataClasses.users
import com.example.firstproject.ui.theme.FirstProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

           MainContent()
        }
    }
}



@Composable
fun MainContent(){
    val user =Users(1, "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content")
val initialUser = remember {
    mutableStateListOf(user)
}
    Box(modifier = Modifier.fillMaxSize()){
        UserList(users = initialUser)
        Button(
            modifier = Modifier
                .padding(24.dp)
                .align(alignment = Alignment.BottomCenter),
            onClick = {
                try {
                    initialUser.add(user)

                }catch (e:Exception){
                   Log.d("error","${e.message}")
                }

            }) {
            Text(text = "Add More")
        }
    }
}
@Composable
fun UserList(users: List<Users>){

        LazyColumn{
            items(users){user ->
                userListCard(user)

            }
        }
    }
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

        Surface(modifier = Modifier.fillMaxSize()) {
            MainContent()
        }


}