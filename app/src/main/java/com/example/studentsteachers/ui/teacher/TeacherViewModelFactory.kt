package com.example.studentsteachers.ui.teacher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.studentsteachers.database.TeacherDao
import com.example.studentsteachers.database.TeacherSpinerList
import com.example.studentsteachers.ui.student.StudentViewModel

@Suppress("UNCHECKED_CAST")
class TeacherViewModelFactory(private val dataSourse:TeacherDao):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TeacherViewModel::class.java)){
            return TeacherViewModel(dataSourse) as T
        } else{
            throw IllegalArgumentException("TeacherViewModel not found")
        }
    }

}