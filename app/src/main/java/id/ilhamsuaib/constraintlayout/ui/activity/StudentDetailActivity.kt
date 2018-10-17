package id.ilhamsuaib.constraintlayout.ui.activity

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import id.ilhamsuaib.constraintlayout.BinarApp
import id.ilhamsuaib.constraintlayout.R
import id.ilhamsuaib.constraintlayout.model.Student
import id.ilhamsuaib.constraintlayout.request
import id.ilhamsuaib.constraintlayout.toast
import id.ilhamsuaib.constraintlayout.ui.fragment.AcademyFragment
import kotlinx.android.synthetic.main.activity_student_detail.*

class StudentDetailActivity : AppCompatActivity() {

    private var student: Student? = null
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        /*data student dari intent*/
        val student = intent?.getParcelableExtra<Student>(AcademyFragment.STUDENT)
        this.title = getString(R.string.student_profile)

        getSpecificStudent(student?.id.toString())
    }

    private fun getSpecificStudent(id: String?) {
        BinarApp.apiServices.getSpecificStudent(id)
                .request({
                    toast("No internet connection")
                }, {
                    if (it != null) {
                        student = it.data
                        showStudent(student)
                    } else {
                        toast("Ex : No data returned, server error")
                    }
                })
    }

    private fun showStudent(student: Student?) {
        student?.imgAvatar?.let {
            imgAvatar.setImageResource(it)
        }
        tvName.text = student?.name
        tvEmail.text = student?.email

        menuInflater.inflate(R.menu.menu_delete_student, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
            R.id.editStudent -> editStudent()
            R.id.deleteStudent -> showDeleteConfirmation()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun editStudent() {
        toast("Edit student is coming soon")

        //todo : tugas : lengkapi dengan menambahkan fitur edit
    }

    private fun showDeleteConfirmation() {
        AlertDialog.Builder(this)
                .setMessage("Anda yakin akan menghapus siswa ${student?.name}?")
                .setPositiveButton("Ya") { dialog, _ ->
                    deleteStudent()
                    dialog.dismiss()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
    }

    private fun deleteStudent() {
        BinarApp.apiServices.deleteStudent(student?.id.toString())
                .request({
                    toast("No intenet connection")
                }, {
                    if (it != null) {
                        toast("Data siswa ${student?.name} berhasil di hapus")
                        finish()
                    } else {
                        toast("Gagal menghapus data siswa")
                    }
                })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menu = menu
        return super.onCreateOptionsMenu(menu)
    }
}
