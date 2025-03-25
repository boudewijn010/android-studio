package com.example.rules

import java.security.MessageDigest

fun String.sha256Hash(): String {
    val digest = MessageDigest.getInstance("SHA-256")
    val hashBytes = digest.digest(this.toByteArray())
    return hashBytes.joinToString("") {
        "%02x".format(it)
    }
}