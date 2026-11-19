package com.example.roomdata.viewmodel.provider

import androidx.lifecycle.SavedStateHandle

class EditViewModel(
    saveStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa): ViewModel() {

    var uiStateSiswa by mutableStateOf(value = UIstateSiswa())
        private set
}
)