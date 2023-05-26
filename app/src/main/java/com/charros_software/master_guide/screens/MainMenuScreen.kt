package com.charros_software.master_guide.screens

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.charros_software.master_guide.R
import com.charros_software.master_guide.reply_app.ui.ReplyMainActivity

@Composable
fun MainMenuScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(onClick = {
            val intent = Intent(context, ReplyMainActivity::class.java)
            context.startActivity(intent)
        }) {
            Text(text = stringResource(id = R.string.button_app_reply))
        }
    }
}