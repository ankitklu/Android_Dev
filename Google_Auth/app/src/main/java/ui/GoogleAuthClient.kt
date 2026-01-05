package ui

import android.content.Intent
import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class GoogleAuthClient(context: Context) {

    private val webClientId =
        "WEB_CLIENT_ID"

    private val options = GoogleSignInOptions.Builder(
        GoogleSignInOptions.DEFAULT_SIGN_IN
    )
        .requestIdToken(webClientId)
        .requestEmail()
        .build()

    val signInClient: GoogleSignInClient =
        GoogleSignIn.getClient(context, options)

    fun getSignedInAccountFromIntent(intent: Intent?): GoogleSignInAccount {
        val task = GoogleSignIn.getSignedInAccountFromIntent(intent)
        return task.getResult(Exception::class.java)
    }
}
