package com.charros_software.master_guide.reply_app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.charros_software.master_guide.reply_app.data.Email
import com.charros_software.master_guide.reply_app.data.EmailsRepository
import com.charros_software.master_guide.reply_app.data.EmailsRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ReplyHomeViewModel(private val emailsRepository: EmailsRepository = EmailsRepositoryImpl()): ViewModel() {

    // UI state exposed to the UI
    private val _uiState = MutableStateFlow(ReplyHomeUIState(loading = true))
    val uiState: StateFlow<ReplyHomeUIState> = _uiState

    init {
        observeEmails()
    }

    private fun observeEmails() {
        viewModelScope.launch {
            emailsRepository.getAllEmails()
                .catch { ex ->
                    _uiState.value = ReplyHomeUIState(error = ex.message)
                }
                .collect { emails ->
                    _uiState.value = ReplyHomeUIState(emails = emails)
                }
        }
    }
}

data class ReplyHomeUIState(
    val emails : List<Email> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)