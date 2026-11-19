package com.example.roomdata.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdata.AplikasiSiswa

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
    }
}

/**
 * Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah instance dari
 * [AplikasiSiswa].
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)

initializer {
    EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
}
//edit : tambah initializer untuk detailViewModel dan editViewmodel

initializer {
    DetailViewModel(savedStateHandle = this.createSavedStateHandle(),
        aplikasiSiswa().container.repositoriSiswa
    )

    initializer {
        EditViewModel(savedStateHandle = this.createSavedStateHandle(),
            aplikasiSiswa().container.repositoriSiswa
        )
    }
}