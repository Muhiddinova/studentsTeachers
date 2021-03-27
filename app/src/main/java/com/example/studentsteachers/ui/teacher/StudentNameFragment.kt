package com.example.studentsteachers.ui.teacher

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.studentsteachers.R
import com.example.studentsteachers.database.RoomDatabase
import com.example.studentsteachers.databinding.StudentNameFragmentBinding
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.StudentTeacher
import com.example.studentsteachers.ui.teacher.adapter.SpinerAdapter

@Suppress("UNCHECKED_CAST", "CAST_NEVER_SUCCEEDS")
class StudentNameFragment : Fragment() ,SpinerAdapter.StudentItemListener{
    private val TAG ="StudentNameFragment"

    private lateinit var viewModel: StudentNameViewModel
    private lateinit var adapter:SpinerAdapter
    private lateinit var binding: StudentNameFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= DataBindingUtil.inflate(inflater,R.layout.student_name_fragment, container, false)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dataSourseName=RoomDatabase.getDatabase(requireContext()).studentDao
        val factory=StudentNameViewModelFactory(dataSourseName)

        viewModel = ViewModelProvider(this,factory).get(StudentNameViewModel::class.java)


    }

    override fun onResume() {
        super.onResume()
        setRv()
        viewModel.getStudentName()?.observe(this){studentName->
            Log.d(TAG, "onActivityCreated: $studentName")
            adapter.updateData(studentName as ArrayList<StudentModel>)

        }
    }

    private fun setRv() {
        adapter=SpinerAdapter(this)
        binding.rvSpiner.adapter=adapter
        binding.rvSpiner.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onClick(modelUser: StudentModel) {
        val teacherId= arguments?.getInt("teacher")
            viewModel.updateStudentTechId(modelUser.studentId,teacherId!!)
     //   viewModel.getLeftJoin()
        Log.d(TAG, "onClick: $modelUser")
    }


}