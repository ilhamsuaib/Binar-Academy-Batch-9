package id.ilhamsuaib.constraintlayout.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ilhamsuaib.constraintlayout.R
import id.ilhamsuaib.constraintlayout.model.Student
import kotlinx.android.synthetic.main.item_student.view.*

/**
 * Created by @ilhamsuaib on 12/10/18.
 * github.com/ilhamsuaib
 */

class StudentAdapter(private val studentList: List<Student>,
                     private val onClick: (student: Student) -> Unit) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val itemView: View = inflater.inflate(R.layout.item_student, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = studentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = studentList[position]
        holder.bind(student)
        holder.itemView.setOnClickListener {
            onClick(student)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(student: Student) {
            itemView.tvName.text = student.name
            itemView.tvEmail.text = student.email
            student.imgAvatar?.let {
                itemView.imgAvatar.setImageResource(it)
            }
        }
    }
}