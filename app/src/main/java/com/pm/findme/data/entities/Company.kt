package com.pm.findme.data.entities


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Company")
class Company(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val companyName: String,
    val companyEmail: String,
    val companyPhone: Int,
    val companyAddress: String,
    val companyCategory: String



)