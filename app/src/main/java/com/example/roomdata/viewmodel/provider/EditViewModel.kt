package com.example.roomdata.viewmodel.provider

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdata.repositori.RepositoriSiswa
import kotlinx.coroutines.launch

class EditViewModel(
    saveStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
): ViewModel() {

    var uiStateSiswa by mutableStateOf(value = UIstateSiswa())
        private set

    private val idSiswa: int = checkNotNull(savedStateHandle[DestinasiDetailSiswa.itemIdArg])
        init{
            viewModelScope.launch {
                uiStateSiswa = repositoriSiswa.getSiswaStream(idSiswa)
                    .filterNotNull()
                    .first()
                    .toUIStateSiswa(isEntryValid=true)

            }
        }
}
)