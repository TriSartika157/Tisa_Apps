package com.itenas.tisaapps.ui.biodata

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.itenas.tisaapps.databinding.FragmentBiodataBinding
import java.util.Calendar

class BiodataFragment : Fragment() {

    private var _binding: FragmentBiodataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBiodataBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Dropdown program studi
        val listProdi = listOf("Teknik Informatika", "Sistem Informasi", "Teknik Elektro", "Manajemen Informatika")
        val adapterProdi = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, listProdi)
        binding.dropdownProdi.setAdapter(adapterProdi)

        // Date picker
        binding.edtDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(requireContext(), { _, y, m, d ->
                binding.edtDate.setText("$d/${m + 1}/$y")
            }, year, month, day)
            datePicker.show()
        }

        // Tombol Submit
        binding.btnSubmit.setOnClickListener {
            val name = binding.edtName.text.toString()
            val nim = binding.edtNim.text.toString()
            val prodi = binding.dropdownProdi.text.toString()
            val gender = if (binding.rbMale.isChecked) "Laki-laki" else if (binding.rbFemale.isChecked) "Perempuan" else ""
            val tanggal = binding.edtDate.text.toString()

            Toast.makeText(requireContext(),
                "Nama: $name\nNIM: $nim\nProdi: $prodi\nGender: $gender\nTanggal: $tanggal",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}