package org.d3if3003.mobpro1.ui.screen

import androidx.lifecycle.ViewModel
import org.d3if3003.mobpro1.model.Mahasiswa

class MainViewModel : ViewModel() {
    val data = getDataDummy()
    private fun getDataDummy(): List<Mahasiswa> {
        val data = mutableListOf<Mahasiswa>()
        data.add(Mahasiswa("Davin Wahyu Wardana", "6706223003", "D3IF-46-03"))
        data.add(Mahasiswa("Muhammad Risqi Briliansyah", "6706223004", "D3IF-46-03"))
        data.add(Mahasiswa("Ghina Salsabilla Zulin", "6706223005", "D3IF-46-03"))
        data.add(Mahasiswa("Adhisty Nayyara Ramadhanti", "6706223006", "D3IF-46-03"))
        data.add(Mahasiswa("Muhammad Faris Akbar", "6706223007", "D3IF-46-03"))
        return data
    }
}