package com.charros_software.master_guide.reply_app.data

import com.charros_software.master_guide.reply_app.data.local.LocalAccountsDataProvider

data class Email(
    val id: Long,
    val sender: Account,
    val recipients: List<Account> = emptyList(),
    val subject: String = "",
    val body: String = "",
    val attachments: List<EmailAttachment> = emptyList(),
    var isImportant: Boolean = false,
    var isStarred: Boolean = false,
    var mailbox: MailboxType = MailboxType.INBOX,
    var createAt: String,
    val threads: List<Email> = emptyList()
) {
    val senderPreview: String = "${sender.fullName} - 4 hrs ago"
    val hasBody: Boolean = body.isNotBlank()
    val hasAttachments: Boolean = attachments.isNotEmpty()
    val recipientsPreview: String = recipients
        .map { it.firstName }
        .fold("") { name, acc -> "$acc, $name" }
    val nonUserAccountRecipients = recipients
        .filterNot { LocalAccountsDataProvider.isUserAccount(it.uid) }
}
