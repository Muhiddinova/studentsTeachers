package com.example.studentsteachers.ui.teacher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentsteachers.database.TeacherDao
import com.example.studentsteachers.database.TeacherSpinerList
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.TeacherModel
import com.example.studentsteachers.repository.TeacherRepository

class TeacherViewModel(dataSourse:TeacherDao) : ViewModel() {
    private val teacherRepo=TeacherRepository(dataSourse)
    private var teachers:LiveData<List<TeacherModel>>?=null
    private var studentName:LiveData<List<StudentModel>> = MutableLiveData()
 init {
     teachers=teacherRepo.getTeacher()
 }
    fun getTeachers():LiveData<List<TeacherModel>>?{
        return teachers
    }
    fun getStudentName():LiveData<List<StudentModel>>{
        return studentName
    }
}