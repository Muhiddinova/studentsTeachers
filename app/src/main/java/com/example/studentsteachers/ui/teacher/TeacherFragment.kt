package com.example.studentsteachers.ui.teacher

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.studentsteachers.R
import com.example.studentsteachers.database.RoomDatabase
import com.example.studentsteachers.databinding.FragmentTeacherBinding
import com.example.studentsteachers.model.TeacherModel
import com.example.studentsteachers.ui.teacher.adapter.TeacherAdapter

class TeacherFragment : Fragment(),TeacherAdapter.TeacherItemListener{
    private val TAG = "TeacherFragment"
    private lateinit var viewModel: TeacherViewModel
    private lateinit var binding: FragmentTeacherBinding
    private lateinit var adapter: TeacherAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_teacher, container, false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dataSourse = RoomDatabase.getDatabase(requireContext()).teacherDao
        val factory = TeacherViewModelFactory(dataSourse)
        viewModel = ViewModelProvider(this, factory).get(TeacherViewModel::class.java)

    }

    override fun onResume() {
        super.onResume()
        setRv()
        viewModel.getTeachers()?.observe(this) { teacher ->
            Log.d(TAG, "onResume:$teacher ")
            adapter.updateData(teacher as ArrayList<TeacherModel>)

        }


        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.teacherAddFragment)
        }

    }

    private fun setRv() {
        adapter = TeacherAdapter(this)
        binding.rvTeacher.adapter = adapter
        binding.rvTeacher.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )



    }

    override fun onClick(teacher: TeacherModel) {

findNavController().navigate(R.id.studentNameFragment , bundleOf("teacher" to teacher.teacherId))

        Toast.makeText(requireContext(), "name: $teacher", Toast.LENGTH_SHORT).show()

    }



}