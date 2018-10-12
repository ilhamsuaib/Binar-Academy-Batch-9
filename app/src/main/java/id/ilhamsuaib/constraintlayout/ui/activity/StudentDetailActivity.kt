package id.ilhamsuaib.constraintlayout.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import id.ilhamsuaib.constraintlayout.R
import id.ilhamsuaib.constraintlayout.model.Student
import id.ilhamsuaib.constraintlayout.ui.fragment.AcademyFragment

class StudentDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val student = intent?.getParcelableExtra<Student>(AcademyFragment.STUDENT)
        this.title = student?.name?.toUpperCase()

        Toast.makeText(this, "Hallo, ${student?.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
