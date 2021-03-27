package com.example.studentsteachers.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.studentsteachers.model.StudentModel
import com.example.studentsteachers.model.StudentTeacher
import com.example.studentsteachers.model.TeacherModel

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(studentModel: StudentModel):Long


    @Query("select   student.studentName, student.studentAge , student.course, student.faculty,teacher.teacherName as teacherName,teacher.subject as subject , techId, student.studentId as id from student left  join teacher on teacher.teacherId=student.techId order by studentName asc")
    fun getLeftJoin():LiveData<List<StudentTeacher>>

    @Query("Select * from student ORDER BY studentName ASC")
    fun getAlphabetizad(): LiveData<List<StudentModel>>

    @Query("Update student set techId = :techId where student.studentId= :studentId")
    suspend fun updateStudentTechId(studentId:Int,techId:Int)

    @Query("Select * from student where techId =-1")
    fun getStudentName():LiveData<List<StudentModel>>




}