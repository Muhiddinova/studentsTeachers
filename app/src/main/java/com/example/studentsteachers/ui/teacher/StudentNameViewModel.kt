package com.example.studentsteachers.ui.teacher

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentsteachers.database.StudentDao
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.StudentTeacher
import com.example.studentsteachers.repository.StudentNameRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentNameViewModel(dataSourseName:StudentDao) : ViewModel() {
    val TAG= "StudentNameViewModel"
    private val studentRepo = StudentNameRepository(dataSourseName)
    private var studentName:LiveData<List<StudentModel>>?=null
    init {
        studentName=studentRepo.getStudentName()
    }
    fun getStudentName():LiveData<List<StudentModel>>?{
        return studentName
    }

 fun  updateStudentTechId(studentId:Int,techId:Int){
     viewModelScope.launch {
         withContext(IO){
             studentRepo.updateStudentTechId(studentId,techId)
             Log.d(TAG, "updateStudentTechId: $studentId")
         }
     }

  }

}