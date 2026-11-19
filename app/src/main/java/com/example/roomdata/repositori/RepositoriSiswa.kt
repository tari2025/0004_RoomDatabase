package com.example.roomdata.repositori

import com.example.roomdata.room.Siswa
import com.example.roomdata.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(private val siswaDao: SiswaDao) : RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}

fun getAllSiswaStream(id: int): Flow<Siswa?>

suspend fun deleteSiswa(Siswa: Siswa)

suspend fun updateSiswa(siswa: Siswa)

}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao

):RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)

    //edit 2 :tambah 3 override
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getSiswa()
    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)
    override suspend fun updateSiswa(siswa: Siswa) = siswaDao.Update(siswa)



}
