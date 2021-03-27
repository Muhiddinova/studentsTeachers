package com.example.studentsteachers.ui.teacher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentsteachers.database.StudentDao
import com.example.studentsteachers.database.TeacherSpinerList

class StudentNameViewModelFactory (private  val dataSourseName:StudentDao): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentNameViewModel::class.java)){
            return StudentNameViewModel(dataSourseName ) as T
        } else {
            throw IllegalArgumentException("StudentNameViewModel not found")
        }
    }
}