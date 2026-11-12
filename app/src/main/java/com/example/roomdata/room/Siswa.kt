package com.example.roomdata.room

@Entity(tableName = "tblSiswa")
data class Siswa (
    @PrimaryKey(autoGenerate = true)
    val id : int = 0,
    val name : String,
    val alamat : String,
    val telpon : String
)