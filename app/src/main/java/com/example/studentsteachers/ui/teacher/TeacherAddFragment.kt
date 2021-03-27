package com.example.studentsteachers.ui.teacher

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.studentsteachers.R
import com.example.studentsteachers.database.RoomDatabase
import com.example.studentsteachers.databinding.TeacherAddFragmentBinding
import com.example.studentsteachers.listeners.EditTextListeners
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class TeacherAddFragment : BottomSheetDialogFragment(),EditTextListeners {

    private lateinit var viewModel: TeacherAddViewModel
    private lateinit var binding:TeacherAddFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding= DataBindingUtil.inflate(inflater,R.layout.teacher_add_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dataSourse=RoomDatabase.getDatabase(requireContext())
        val factory=TeacherAddViewModelFactory(this,dataSourse.teacherDao)
        viewModel = ViewModelProvider(this,factory).get(TeacherAddViewModel::class.java)
        binding.addViewModel=viewModel
    }

    override fun onError(type: String) {
       when (type) {
            "name" -> {
            binding.etName.error = "name is required"
        }
            "age" -> {
            binding.etAge.error = "age is required"
        }
            "subject" -> {
            binding.etSubject.error = "subject is required"
        }
        }
    }

}