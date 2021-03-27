package com.example.studentsteachers.ui.student

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.studentsteachers.R
import com.example.studentsteachers.database.RoomDatabase
import com.example.studentsteachers.databinding.FragmentStudentBinding
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.StudentTeacher
import com.example.studentsteachers.ui.student.adapter.StudentAdapter

@Suppress("UNCHECKED_CAST")
class StudentFragment : Fragment() {

    private val TAG = "StudentFragment"

    private lateinit var viewModel: StudentViewModel
    private lateinit var binding: FragmentStudentBinding
    private lateinit var adapter: StudentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_student, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dataSource = RoomDatabase.getDatabase(requireContext()).studentDao
        val factory = StudentViewModelFactory(dataSource)
        viewModel = ViewModelProvider(this, factory).get(StudentViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        setRv()

        viewModel.getLeftJoin()?.observe(this) { studentName ->
            Log.d(TAG, "getLeftJoin: $studentName")
            adapter.updateData(studentName as ArrayList<StudentTeacher>)


        }
//        viewModel.getStudents()?.observe(this) { student ->
//            Log.d(TAG, "onResume: $student")
//            adapter.updateData(student as ArrayList<StudentTeacher>)
//        }


        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.studentAddFragment)
        }
    }

    private fun setRv() {
        adapter = StudentAdapter {

        }
        binding.rvStudent.adapter = adapter
        binding.rvStudent.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }
}