package com.itenas.tisaapps.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.itenas.tisaapps.R
import com.itenas.tisaapps.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newsList = listOf(
            News("Wisuda Itenas 2025", "02 Nov 2025",
                "Itenas menggelar wisuda untuk ribuan mahasiswa...",
                R.drawable.ic_launcher_background),
            News("Lomba IT Nasional", "30 Okt 2025",
                "Delegasi Itenas berhasil meraih juara umum...",
                R.drawable.ic_launcher_background),
            News("Seminar AI & Robotics", "28 Okt 2025",
                "Acara seminar teknologi masa depan di Aula Itenas...",
                R.drawable.ic_launcher_background)
        )

        binding.rvNews.adapter = NewsAdapter(newsList)
        binding.rvNews.layoutManager = LinearLayoutManager(requireActivity())
    }
}