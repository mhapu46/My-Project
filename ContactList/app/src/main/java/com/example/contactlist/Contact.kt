package com.example.contactlist

data class Contact(
    val id: Long,
    val contactName: String,
    val phone: String,
    val email: String,
    val address: String
)
val contactList= mutableListOf<Contact>(

)
