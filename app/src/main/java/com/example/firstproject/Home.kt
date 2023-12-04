package com.example.firstproject

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.navArgument
import com.example.firstproject.DataClasses.Users


@Composable
fun MainContent(navController:NavHostController? =null){
    val user = Users(1, "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content")
    val initialUser = remember {
        mutableStateListOf(user)
    }
    Box(modifier = Modifier.fillMaxSize()){
        UserList(users = initialUser,navController)
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
fun UserList(users: List<Users> ,navController: NavHostController?){

    LazyColumn{
        items(users){user ->
            userListCard(user, navController = navController)

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