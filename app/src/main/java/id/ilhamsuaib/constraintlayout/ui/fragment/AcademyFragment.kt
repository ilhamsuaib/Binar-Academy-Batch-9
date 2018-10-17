package id.ilhamsuaib.constraintlayout.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.ilhamsuaib.constraintlayout.BinarApp
import id.ilhamsuaib.constraintlayout.R
import id.ilhamsuaib.constraintlayout.request
import id.ilhamsuaib.constraintlayout.model.Student
import id.ilhamsuaib.constraintlayout.ui.activity.StudentDetailActivity
import id.ilhamsuaib.constraintlayout.ui.adapter.StudentAdapter
import kotlinx.android.synthetic.main.fragment_academy.view.*

class AcademyFragment : Fragment() {

    companion object {
        const val STUDENT = "student"
    }

    private val api = BinarApp.apiServices
    private val studentList = mutableListOf<Student>()
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_academy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        studentAdapter = StudentAdapter(studentList) {
            val toStudentDetail = Intent(context, StudentDetailActivity::class.java)
            toStudentDetail.putExtra(STUDENT, it)
            startActivity(toStudentDetail)
        }

        /**
         * layout manager :
         * 1. horizontal : LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
         * 2. vertical : LinearLayoutManager(context)
         * 3. grid (3 columns) : GridLayoutManager(context, 3)
         * 4. etc.
         * */

        /**
         * view.rvStudents.layoutManager = LinearLayoutManager(context)
         * view.rvStudents.adapter = studentAdapter
         * */

        view.rvStudents.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = studentAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        getDataStudent()
    }

    private fun getDataStudent() {
        /**
         * student :
         * 1. Gigih
         * 2. Kahar
         * 3. Sambudi
         *
         * Tugas :
         * Menampilkan progress status saat load data students pada AcademyFragment
         * dan menghilangkan loading progress saat data telah selesai di load
         * */

        showProgress(true)
        api.getAllStudents().request({
            showMessage("Tidak ada koneksi internet")
            showProgress(false)
        }, { response ->
            /* `dataStudents` : untuk menyimpan data students dari response*/
            val dataStudents = response?.data
            dataStudents?.let {
                studentList.clear()
                studentList.addAll(it)
                studentAdapter.notifyDataSetChanged()
            }
            showProgress(false)
        })
    }

    private fun showProgress(show: Boolean) {
        view?.progress?.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
