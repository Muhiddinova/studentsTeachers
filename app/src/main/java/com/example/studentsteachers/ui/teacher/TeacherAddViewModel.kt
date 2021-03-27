package com.example.studentsteachers.ui.teacher

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentsteachers.database.TeacherDao
import com.example.studentsteachers.database.TeacherSpinerList
import com.example.studentsteachers.listeners.EditTextListeners
import com.example.studentsteachers.model.TeacherModel
import com.example.studentsteachers.repository.TeacherRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log

class TeacherAddViewModel (private val listener:EditTextListeners,dataSourse:TeacherDao): ViewModel() {
    private val TAG ="TeacherAddViewModel"
    var name : String? = null
    var age: String?=null
    var subject: String? = null
    private val teacherRepo=TeacherRepository(dataSourse)
    fun addButtonCliked(view:View){
        if (!name.isNullOrEmpty()){
            if (!age.isNullOrEmpty()){
                if (!subject.isNullOrEmpty()){
                    val teacher=TeacherModel(name!!,age!!.toInt() , subject!!)
                    Log.d(TAG, "addButtonCliked: $teacher")
                    viewModelScope.launch {
                       val rowId =  withContext(IO){
                            teacherRepo.insertTeacher(teacher)
                        }
                        Log.d(TAG, "addButtonCliked: $rowId")
                    }

                }else{
                    listener.onError("subject")
                }
            } else{
                listener.onError("age")
            }
        } else{
            listener.onError("name")
        }
    }

}