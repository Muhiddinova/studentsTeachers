package com.example.studentsteachers.ui.student

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentsteachers.database.StudentDao
import com.example.studentsteachers.listeners.EditTextListeners


class StudentAddViewModelFactory(private val listener: EditTextListeners, private val dataSource: StudentDao):ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentAddViewModel::class.java)){
            return StudentAddViewModel(listener,dataSource) as T
        } else {
            throw IllegalArgumentException("AddViewModel class not found")
        }
    }

}