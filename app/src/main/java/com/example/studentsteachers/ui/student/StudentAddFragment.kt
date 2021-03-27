package com.example.studentsteachers.ui.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.studentsteachers.R
import com.example.studentsteachers.database.RoomDatabase
import com.example.studentsteachers.databinding.StudentAddFragmentBinding
import com.example.studentsteachers.listeners.EditTextListeners
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class StudentAddFragment : BottomSheetDialogFragment(), EditTextListeners {

    companion object {
        fun newInstance() = StudentAddFragment()
    }

    private lateinit var viewModel: StudentAddViewModel
    private lateinit var binding: StudentAddFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.student_add_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dataSource = RoomDatabase.getDatabase(requireContext())
        val factory = StudentAddViewModelFactory(this, dataSource.studentDao)
        viewModel = ViewModelProvider(this,factory).get(StudentAddViewModel::class.java)
        binding.addViewModel = viewModel
    }

    override fun onError(type: String) {
        when (type) {
            "name" -> {
                binding.etName.error = "name is required"
            }
            "age" -> {
                binding.etAge.error = "name is required"
            }
            "course" -> {
                binding.etSubject.error = "name is required"
            }
            "faculty" -> {
                binding.etFaculty.error = "name is required"
            }

        }
    }

}