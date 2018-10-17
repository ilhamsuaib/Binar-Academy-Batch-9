package id.ilhamsuaib.constraintlayout.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import id.ilhamsuaib.constraintlayout.BinarApp
import id.ilhamsuaib.constraintlayout.R
import id.ilhamsuaib.constraintlayout.request
import id.ilhamsuaib.constraintlayout.toast
import kotlinx.android.synthetic.main.activity_new_student.*

/**
 * Created by @ilhamsuaib on 17/10/18.
 * github.com/ilhamsuaib
 */

class NewStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        setupView()
    }

    private fun setupView() {
        this.title = getString(R.string.new_student)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnSave.setOnClickListener {
            saveStudent()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    private fun saveStudent() {
        val name = edtName.text.toString()
        val email = edtEmail.text.toString()

        if (name.isBlank() || email.isBlank()) {
            toast(getString(R.string.nama_dan_email_tidak_boleh_kosong))
            return /*untuk menghentikan proses pada function*/
        }

        /*eksekusi save data ke API*/
        showProgress(true)
        val map = mutableMapOf<String, String>()
        map["email"] = email
        map["name"] = name
        BinarApp.apiServices.saveStudent(map)
                .request({
                    toast(getString(R.string.gagal_menyimpan))
                    showProgress(false)
                }, {
                    if (it != null) {
                        val student = it.data
                        toast("Data siswa ${student?.name} berhasil disimpan")
                        clearForm()
                    } else {
                        toast(getString(R.string.gagal_menyimpan))
                    }
                    showProgress(false)
                })
    }

    private fun showProgress(show: Boolean) {
        if (show) {
            progress.visibility = View.VISIBLE
            btnSave.visibility = View.GONE
        } else {
            progress.visibility = View.GONE
            btnSave.visibility = View.VISIBLE
        }
    }

    private fun clearForm() {
        edtEmail.setText("")
        edtName.setText("")
        edtName.requestFocus()
    }
}