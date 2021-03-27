package com.example.studentsteachers.ui.teacher.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsteachers.databinding.SpinerItemBinding
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.StudentTeacher


class SpinerAdapter(private  val itemClickListener:StudentItemListener):
    RecyclerView.Adapter<SpinerAdapter.VH>() {
    interface   StudentItemListener {

        fun onClick(modelUser: StudentModel)
    }
        private  var list = arrayListOf<StudentModel>()

        class VH(private val binding: SpinerItemBinding): RecyclerView.ViewHolder(binding.root){
            fun onBind(student: StudentModel){
                binding.student= student

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val inflater = LayoutInflater.from(parent.context)
            val binding = SpinerItemBinding.inflate(inflater, parent, false)
            return VH(binding)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            holder.itemView.setOnClickListener {
                itemClickListener.onClick(list[position])

            }
            holder.onBind(list[position])
        }

        override fun getItemCount(): Int {
            return  list.size
        }

        fun updateData(list:ArrayList<StudentModel>){
            this.list = list
            notifyDataSetChanged()
        }
    }



