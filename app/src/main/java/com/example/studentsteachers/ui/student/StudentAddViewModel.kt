package com.example.studentsteachers.ui.student

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentsteachers.database.StudentDao
import com.example.studentsteachers.listeners.EditTextListeners
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.StudentTeacher
import com.example.studentsteachers.repository.StudentRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentAddViewModel (private val listener:EditTextListeners,dataSource: StudentDao): ViewModel() {
    private val TAG ="StudentAddViewModel"

    var studentName: String? = null
    var studentAge: String?=null
    var course: String? = null
    var faculty: String? = null


    private val studentRepo=StudentRepository(dataSource)
    fun addButtonCliked(view: View){
        if (!studentName.isNullOrEmpty()){
            if (!studentAge.isNullOrEmpty()){
                if (!course.isNullOrEmpty()){
                    if (!faculty.isNullOrEmpty()){


                        val student =StudentModel(studentName!!,studentAge!!.toInt(),course!!,faculty!! )
                        Log.d(TAG, "addButtonCliked: $student")
                        viewModelScope.launch {
                         val rowId=   withContext(IO){
                                studentRepo.insertStudent(student)
                             studentRepo.getLeftJoin()
                             Log.d(TAG, "addButtonCliked: $studentAge")
                            }
                            Log.d(TAG, "addButtonCliked: rowId: $rowId")
                        }

                    }else{
                        listener.onError("faculty")
                    }
                }else{
                    listener.onError("course")
                }
            } else{
                listener.onError("studentAge")
            }
        }else{
            listener.onError("studentName")
        }
    }
}