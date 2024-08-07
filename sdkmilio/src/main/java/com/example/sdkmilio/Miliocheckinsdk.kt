package com.example.miliocheckinsdk

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sdkmilio.TitleActivity


@Composable
fun Miliocheckinsdk(name: String, modifier: Modifier.Companion = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

fun launchTitleActivity(context: Context, title: String) {
    val intent = Intent(context, TitleActivity::class.java).apply {
        putExtra("TITLE_KEY", title)
    }
    context.startActivity(intent)
//    Toast.makeText(context,"Esto es un sdk",Toast.LENGTH_LONG).show()
}

fun longToastShow(context: Context, msg:String){
    Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
}