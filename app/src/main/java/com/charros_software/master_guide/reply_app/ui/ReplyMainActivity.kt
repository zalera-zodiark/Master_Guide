package com.charros_software.master_guide.reply_app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.charros_software.master_guide.reply_app.data.local.LocalEmailsDataProvider
import com.charros_software.master_guide.ui.theme.Master_GuideTheme

class ReplyMainActivity: ComponentActivity() {

    private val viewModel: ReplyHomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Master_GuideTheme {
                val uiState = viewModel.uiState.collectAsState().value
                ReplyApp(uiState)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyAppPreview() {
    Master_GuideTheme {
        ReplyApp(replyHomeUIState = ReplyHomeUIState(
            emails = LocalEmailsDataProvider.allEmails
        ))
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun ReplyAppPreviewTablet() {
    Master_GuideTheme {
        ReplyApp(replyHomeUIState = ReplyHomeUIState(
            emails = LocalEmailsDataProvider.allEmails
        )
        )
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun ReplyAppPreviewDesktop() {
    Master_GuideTheme {
        ReplyApp(replyHomeUIState = ReplyHomeUIState(
            emails = LocalEmailsDataProvider.allEmails
        ))
    }
}