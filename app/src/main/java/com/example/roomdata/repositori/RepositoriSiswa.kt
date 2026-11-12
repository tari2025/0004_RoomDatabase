package com.example.roomdata.repositori

interface RepositoiSiswa {
    fun gelAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa: Siswa)

}

class offlineRepositoriSiswa(private val siswaDao: SiswaDao) : RepositoriSiswa {
    override fun getAllSiswaStream() : Flow<List<Ssiswa>> = siswaDao.get.AllSsiwa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}