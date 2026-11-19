package com.example.roomdata.viewmodel.provider

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdata.repositori.RepositoriSiswa
import com.example.roomdata.uicontroller.route.DestinasiEditSiswa
import com.example.roomdata.viewmodel.DetailSiswa
import com.example.roomdata.viewmodel.UIStateSiswa
import com.example.roomdata.viewmodel.toDetailSiswa
import com.example.roomdata.viewmodel.toSiswa
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private val siswaId: Int = checkNotNull(savedStateHandle[DestinasiEditSiswa.itemIdArg])

    init {
        viewModelScope.launch {
            repositoriSiswa.getSiswa(siswaId)
                .filterNotNull()
                .collect { siswa ->
                    uiStateSiswa = UIStateSiswa(
                        detailSiswa = siswa.toDetailSiswa(),
                        isEntryValid = validasiInput(siswa.toDetailSiswa())
                    )
                }
        }
    }

    private fun validasiInput(detailSiswa: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(detailSiswa) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(
            detailSiswa = detailSiswa,
            isEntryValid = validasiInput(detailSiswa)
        )
    }

    suspend fun updateSiswa() {
        if (validasiInput()) {
            repositoriSiswa.updateSiswa(uiStateSiswa.detailSiswa.toSiswa())
        }
    }
}