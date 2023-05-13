package com.example.lovecalculator.localRoom


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.remote.LoveModel
@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("Select * FROM love_table ORDER BY firstName ASC")
    fun getAll(): List<LoveModel>
}