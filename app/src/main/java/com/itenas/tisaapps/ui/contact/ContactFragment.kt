package com.itenas.tisaapps.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.itenas.tisaapps.R
import com.itenas.tisaapps.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val contactList = listOf(
            Contact("Dewa Tri Wijaya", "081234561", R.drawable.ic_person),
            Contact("Siti Rahma", "081234562", R.drawable.ic_person),
            Contact("Agus Pratama", "081234563", R.drawable.ic_person),
            Contact("Rina Permata", "081234564", R.drawable.ic_person),
            Contact("Budi Santoso", "081234565", R.drawable.ic_person),
            Contact("Nur Aisyah", "081234566", R.drawable.ic_person),
            Contact("Putri Amelia", "081234567", R.drawable.ic_person),
            Contact("Ahmad Rizki", "081234568", R.drawable.ic_person),
            Contact("Dian Sari", "081234569", R.drawable.ic_person),
            Contact("Kevin Hartono", "081234570", R.drawable.ic_person),
            Contact("Lina Marlina", "081234571", R.drawable.ic_person),
            Contact("Fahri Ramadhan", "081234572", R.drawable.ic_person),
            Contact("Dewi Anggraeni", "081234573", R.drawable.ic_person),
            Contact("Reza Nugroho", "081234574", R.drawable.ic_person),
            Contact("Maya Salsabila", "081234575", R.drawable.ic_person)
        )

        binding.rvContacts.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvContacts.adapter = ContactAdapter(contactList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}