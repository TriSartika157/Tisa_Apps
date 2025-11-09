package com.itenas.tisaapps.ui.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.itenas.tisaapps.databinding.FragmentWeatherBinding
import org.json.JSONObject
import java.nio.charset.Charset

class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CuacaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadCuacaData()
    }

    private fun setupRecyclerView() {
        adapter = CuacaAdapter(emptyList())
        binding.rvCuaca.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCuaca.adapter = adapter
    }

    private fun loadCuacaData() {
        try {
            // 🔹 Baca file JSON dari assets
            val inputStream = requireContext().assets.open("cuaca.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val jsonString = String(buffer, Charset.forName("UTF-8"))

            // 🔹 Parse JSON
            val jsonObject = JSONObject(jsonString)
            val dataArray = jsonObject.getJSONArray("data")
            val lokasi = jsonObject.getJSONObject("lokasi")

            val cuacaList = mutableListOf<CuacaDetail>()

            // Ambil data hari pertama
            val firstDay = dataArray.getJSONObject(0)
            val cuacaArray = firstDay.getJSONArray("cuaca").getJSONArray(0)

            for (i in 0 until cuacaArray.length()) {
                val c = cuacaArray.getJSONObject(i)
                cuacaList.add(
                    CuacaDetail(
                        local_datetime = c.getString("local_datetime"),
                        weather_desc = c.getString("weather_desc"),
                        t = c.getInt("t"),
                        image = c.getString("image")
                    )
                )
            }

            // 🔹 Update UI
            binding.tvProvinsi.text = lokasi.getString("provinsi")
            binding.tvKota.text = lokasi.getString("kotkab")
            binding.tvKecamatan.text = lokasi.getString("kecamatan")

            // 🔹 Update adapter
            adapter = CuacaAdapter(cuacaList)
            binding.rvCuaca.adapter = adapter

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
