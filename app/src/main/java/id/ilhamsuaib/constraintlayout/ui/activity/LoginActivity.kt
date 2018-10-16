package id.ilhamsuaib.constraintlayout.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.ilhamsuaib.constraintlayout.R
import id.ilhamsuaib.constraintlayout.data.PreferenceHelper
import id.ilhamsuaib.constraintlayout.data.PreferenceKey
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var pref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            login()
        }

        pref = PreferenceHelper(this)

        checkLoginStatus()
    }

    private fun checkLoginStatus() {
        val hasLogin = pref.getBoolean(PreferenceKey.HAS_LOGIN)
        if (hasLogin) {
            goHomePage()
        }
    }

    fun login() {

        /**logic login
         * 1. mengambil data dari edit text : username dan password
         * 2. cek `apakah username dan password sudah diisi?`
         * 3. jika `YA` : eksekusi perintah uk pindah halaman
         * 4. jika `TIDAK` : munculkan pesan `Username dan password harus diisi!` */

        val username = edtUsername.text.toString()
        val password = edtPassword.text.toString()

        if (username.isNotBlank() && password.isNotBlank()) {
            saveLoginData(username)
            goHomePage()
        } else {
            /*perintah tampilkan pesan*/
            Toast.makeText(this, "Username dan password harus diisi!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveLoginData(username: String) {
        pref.putString(PreferenceKey.USERNAME, username)
        pref.putBoolean(PreferenceKey.HAS_LOGIN, true)
    }

    private fun goHomePage() {
        /*perintah pindah halaman*/
        val goHome = Intent(this, HomeActivity::class.java)
        startActivity(goHome)
        finish()
    }
}
