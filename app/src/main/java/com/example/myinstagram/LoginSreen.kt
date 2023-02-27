package com.example.myinstagram

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    Column(modifier = modifier) {
        BrandLogo()
        Spacer(modifier = Modifier.size(16.dp))
        Email(email, { email = it })
        Spacer(modifier = Modifier.size(4.dp))
        Password(password, { password = it })
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9), //0xFF va en lugar del #
        modifier = modifier
    )
}

@Composable
fun Password(password: String, onTextChange: (String) -> Unit) {
    TextField(value = password , onValueChange = { onTextChange(it) })
}

@Composable
fun Email( email: String, onTextChange:(String) -> Unit) {
    TextField(value = email , onValueChange = { onTextChange(it) })
}

@Composable
fun BrandLogo() {
    Image(painter = painterResource(id = R.drawable.insta), contentDescription = "Logo Insta")
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity // para castear el contexto como una actividad
    Icon(
        imageVector = Icons.Default.Close ,
        contentDescription = "Close app",
        modifier.clickable { activity.finish() }
    )
}


