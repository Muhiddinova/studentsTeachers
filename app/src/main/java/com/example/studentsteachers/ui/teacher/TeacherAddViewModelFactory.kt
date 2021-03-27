package com.example.studentsteachers.ui.teacher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentsteachers.database.TeacherDao
import com.example.studentsteachers.database.TeacherSpinerList
import com.example.studentsteachers.listeners.EditTextListeners

@Suppress("UNCHECKED_CAST")
class TeacherAddViewModelFactory(private val listener:EditTextListeners, private val dataSourse:TeacherDao):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeacherAddViewModel::class.java)){
            return TeacherAddViewModel(listener,dataSourse) as T
        } else {
            throw IllegalArgumentException("AddViewModel class not found")
        }
    }

}