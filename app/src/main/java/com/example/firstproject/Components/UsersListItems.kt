package com.example.firstproject

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.Coil
import coil.compose.rememberImagePainter
import com.example.firstproject.DataClasses.Users

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun userListCard(user:Users , navController: NavHostController? =null){
    val context = LocalContext.current
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
//            Image(painter = painterResource(id = R.drawable.profile),
//                contentDescription = "",
//                contentScale= ContentScale.Crop,
//                modifier = Modifier
//                    .size(120.dp)
//                    .clip(CircleShape)
//            )


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
                user?.text?.let { Text(text = it) }

                Button(onClick = {
                    //perfotm button action
                    navController?.navigate("details?user=${user?.text}")
//                    Toast.makeText(context,"Simplified Coding", Toast.LENGTH_LONG).show()

                }) {
                    Text(text = stringResource(id = R.string.view_profile))
                }
            }
        }
    }


}
