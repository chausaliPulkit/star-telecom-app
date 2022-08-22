package me.asiimwedismas.startelecom.feature.login

data class CredentialsFragUI(
    val username: String? = null,
    val password: String? = null,
    val isSearchingForUser: Boolean = false,
) {
    val isSignInButtonEnabled: Boolean
        get() = !username.isNullOrBlank() && !password.isNullOrBlank() && !isSearchingForUser

    val canEditCredentials: Boolean
        get() = !isSearchingForUser
}