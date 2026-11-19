package com.example.roomdata.uicontroller.route

import com.example.roomdata.R

object DestinasiEditSiswa : DestinasiNavigasi {
    override val route = "detail_siswa"

    override val titleRes = R.string.detail_siswa

    const val itemIdArg = "idSiswa"

    val routeWithArgs   = "$route/{$itemIdArg"
}