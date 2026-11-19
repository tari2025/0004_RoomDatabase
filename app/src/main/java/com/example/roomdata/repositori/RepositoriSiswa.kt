package com.example.roomdata.repositori

import com.example.roomdata.room.Siswa
import com.example.roomdata.room.SiswaDao
import kotlinx.coroutines.flow.Flow

// 1. Interface (Hanya deklarasi, tidak ada isi {})
interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    fun getSiswa(id: Int): Flow<Siswa?>
    suspend fun insertSiswa(siswa: Siswa)
    suspend fun deleteSiswa(siswa: Siswa)
    suspend fun updateSiswa(siswa: Siswa)
}

// 2. Class Implementasi (Hanya ada SATU class)
class OfflineRepositoriSiswa(private val siswaDao: SiswaDao) : RepositoriSiswa {

    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()

    override fun getSiswa(id: Int): Flow<Siswa?> = siswaDao.getSiswa(id)

    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insertSiswa(siswa)

    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.deleteSiswa(siswa)

    override suspend fun updateSiswa(siswa: Siswa) = siswaDao.updateSiswa(siswa)
}