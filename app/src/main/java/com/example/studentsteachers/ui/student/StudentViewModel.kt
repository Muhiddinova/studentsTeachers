package com.example.studentsteachers.ui.student

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentsteachers.database.StudentDao
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.StudentTeacher
import com.example.studentsteachers.model.TeacherModel
import com.example.studentsteachers.repository.StudentRepository

class StudentViewModel(datSourse:StudentDao) : ViewModel() {
private val TAG="StudentViewModel"
    private val studentRepo = StudentRepository(datSourse)
    private var students:LiveData<List<StudentModel>>?=null
    private var studentTeacher:LiveData<List<StudentTeacher>>?=null



    init {
        students = studentRepo.getAlpha()
        studentTeacher=studentRepo.getLeftJoin()
    }

    fun getLeftJoin():LiveData<List<StudentTeacher>>?{
        Log.d(TAG, "getLeftJoin: $studentTeacher")
        return studentTeacher
    }
}