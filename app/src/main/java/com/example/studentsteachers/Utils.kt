package com.example.studentsteachers

import com.example.studentsteachers.model.StudentModel

fun List<StudentModel>.seperateName(): ArrayList<String> {
    val list = arrayListOf<String>()

    for (studentModel in this) {
        list.add(studentModel.studentName)
    }
    return list
}