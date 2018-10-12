package id.ilhamsuaib.constraintlayout.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.ilhamsuaib.constraintlayout.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            login()
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
            /*perintah pindah halaman*/
            val goHome = Intent(this, HomeActivity::class.java)
            startActivity(goHome)
            finish()
        } else {
            /*perintah tampilkan pesan*/
            Toast.makeText(this, "Username dan password harus diisi!", Toast.LENGTH_SHORT).show()
        }
    }
}
