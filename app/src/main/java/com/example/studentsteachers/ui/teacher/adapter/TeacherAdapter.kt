package com.example.studentsteachers.ui.teacher.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsteachers.databinding.TeacherItemBinding
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.TeacherModel

class TeacherAdapter(private val itemClickListener: TeacherItemListener) :
    RecyclerView.Adapter<TeacherAdapter.VH>() {
    interface TeacherItemListener{
        fun onClick(teacher: TeacherModel)
    }


    private var list = arrayListOf<TeacherModel>()

    fun updateData(list: ArrayList<TeacherModel>) {
        this.list = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherAdapter.VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TeacherItemBinding.inflate(inflater, parent, false)
        return TeacherAdapter.VH(binding)
    }

    override fun onBindViewHolder(holder: TeacherAdapter.VH, position: Int) {
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(list[position])
        }
        holder.onBind(list[position], list[position])

    }

    override fun getItemCount() = list.size


    class VH(private val binding: TeacherItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(teacher: TeacherModel, itemClickListener: TeacherModel) {
            binding.teacher = teacher


        }
    }
}