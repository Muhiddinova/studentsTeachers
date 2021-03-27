package com.example.studentsteachers.ui.student

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentsteachers.database.StudentDao

class StudentViewModelFactory(private val dataSource:StudentDao):ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StudentViewModel::class.java)){
            return StudentViewModel(dataSource) as T
        } else{
            throw IllegalArgumentException("StudentViewModel not found")
        }
    }
}