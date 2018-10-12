package id.ilhamsuaib.constraintlayout.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ilhamsuaib.constraintlayout.R
import id.ilhamsuaib.constraintlayout.model.Student
import id.ilhamsuaib.constraintlayout.ui.adapter.StudentAdapter
import kotlinx.android.synthetic.main.fragment_academy.view.*
import id.ilhamsuaib.constraintlayout.ui.activity.StudentDetailActivity

class AcademyFragment : Fragment() {

    companion object {
        const val STUDENT = "student"
    }

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

        getDataStudent()
    }

    private fun getDataStudent() {
        studentList.add(Student(
                id = "1",
                name = "Ilham Suaib",
                email = "ilhamsuaib10@gmail.com",
                imgAvatar = R.drawable.isyana
        ))

        studentList.add(Student(
                id = "2",
                name = "Ahmad",
                email = "ahmad@gmail.com",
                imgAvatar = R.drawable.isyana
        ))

        studentList.add(Student(
                id = "3",
                name = "Bayu Prasetyo",
                email = "bayu@gmail.com",
                imgAvatar = R.drawable.isyana
        ))

        studentList.add(Student(
                id = "4",
                name = "Putri",
                email = "putri@gmail.com",
                imgAvatar = R.drawable.isyana
        ))

        studentList.add(Student(
                id = "5",
                name = "Putra",
                email = "putra@gmail.com",
                imgAvatar = R.drawable.isyana
        ))

        (0..10).forEach {
            studentList.add(Student(
                    id = "id$it",
                    name = "Siswa ${it.plus(1)}",
                    email = "siswa${it.plus(1)}@gmail.com",
                    imgAvatar = R.drawable.isyana
            ))
        }

        studentAdapter.notifyDataSetChanged()
    }
}
