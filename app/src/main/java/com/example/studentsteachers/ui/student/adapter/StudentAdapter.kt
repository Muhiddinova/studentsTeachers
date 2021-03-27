package com.example.studentsteachers.ui.student.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsteachers.databinding.StudentItemBinding
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.StudentTeacher

class StudentAdapter(private val itemClickListener: ((StudentTeacher) -> Unit)) :
    RecyclerView.Adapter<StudentAdapter.VH>() {

    private var list = arrayListOf<StudentTeacher>()

    fun updateData(list: ArrayList<StudentTeacher>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = StudentItemBinding.inflate(inflater, parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder:VH, position: Int) {
        holder.itemView.setOnClickListener {
            itemClickListener.invoke(list[position])
        }
        holder.onBind(list[position])

    }

    override fun getItemCount()=list.size

    class VH(private val binding: StudentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(student :StudentTeacher) {
            binding.student=student
            if (student.teacherName==null && student.subject==null){
                binding.tvTechId.visibility=View.GONE
                binding.tvTechSubject.visibility=View.GONE
            }
            else{
                binding.tvTechId.visibility=View.VISIBLE
                binding.tvTechSubject.visibility=View.VISIBLE
            }
        }
    }
}