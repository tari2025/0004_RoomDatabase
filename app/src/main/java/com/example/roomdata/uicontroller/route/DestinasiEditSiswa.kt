package com.example.roomdata.uicontroller.route

import com.example.example.myroomsiswa.R

object DestinasiEditSiswa : DestinasiNavigasi {
    override val route = "item_edit"

    override val titlrRes = R.string.edit_siswa

    const val itemIdArg = "idSiswa"

    val routeWithArgs   = "$route/{$itemIdArg"
}