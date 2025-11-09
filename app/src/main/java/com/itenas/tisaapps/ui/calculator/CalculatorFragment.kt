package com.itenas.tisaapps.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.itenas.tisaapps.databinding.FragmentCalculatorBinding
import kotlin.math.sqrt

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!

    private var current = ""
    private var operator = ""
    private var firstNumber = 0.0
    private var lastPressedOperator = false
    private var hasDot = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupNumberButtons()
        setupOperators()
        setupFunctions()
    }

    private fun setupNumberButtons() {
        val digits = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3, binding.btn4,
            binding.btn5, binding.btn6, binding.btn7, binding.btn8, binding.btn9
        )

        digits.forEachIndexed { index, button ->
            button.setOnClickListener {
                if (lastPressedOperator) {
                    // mulai angka baru setelah operator
                    current = ""
                    lastPressedOperator = false
                    hasDot = false
                }
                current += index.toString()
                binding.tvResult.text = binding.tvResult.text.toString() + index.toString()
            }
        }

        // Tombol titik (.)
        binding.btnDot.setOnClickListener {
            if (!hasDot) {
                if (current.isEmpty()) current = "0"
                current += "."
                binding.tvResult.text = binding.tvResult.text.toString() + "."
                hasDot = true
            }
        }
    }

    private fun setupOperators() {
        fun setOperator(op: String) {
            if (current.isNotEmpty()) {
                firstNumber = current.toDoubleOrNull() ?: 0.0
                operator = op
                binding.tvResult.text = binding.tvResult.text.toString() + " $op "
                lastPressedOperator = true
            }
        }

        binding.btnPlus.setOnClickListener { setOperator("+") }
        binding.btnMinus.setOnClickListener { setOperator("-") }
        binding.btnMultiply.setOnClickListener { setOperator("×") }
        binding.btnDivide.setOnClickListener { setOperator("÷") }

        binding.btnEqual.setOnClickListener { calculateResult() }

        binding.btnClear.setOnClickListener {
            current = ""
            operator = ""
            firstNumber = 0.0
            hasDot = false
            binding.tvResult.text = ""
        }
    }

    private fun calculateResult() {
        val text = binding.tvResult.text.toString().trim()
        val parts = text.split(" ")

        // pastikan format "angka operator angka"
        if (parts.size < 3 || parts[2].isEmpty()) {
            binding.tvResult.text = "Error"
            return
        }

        val first = parts[0].toDoubleOrNull() ?: 0.0
        val op = parts[1]
        val second = parts[2].toDoubleOrNull() ?: 0.0

        val result = when (op) {
            "+" -> first + second
            "-" -> first - second
            "×" -> first * second
            "÷" -> if (second != 0.0) first / second else Double.NaN
            else -> Double.NaN
        }

        if (result.isNaN()) {
            binding.tvResult.text = "Tidak bisa dibagi 0"
        } else {
            binding.tvResult.text = "$text = $result"
        }

        current = result.toString()
    }

    private fun setupFunctions() {
        // Kuadrat
        binding.btnSquare.setOnClickListener {
            val value = current.toDoubleOrNull()
            if (value != null) {
                val result = value * value
                binding.tvResult.text = "$value² = $result"
                current = result.toString()
            } else {
                binding.tvResult.text = "Error"
            }
        }

        // Akar
        binding.btnRoot.setOnClickListener {
            val value = current.toDoubleOrNull()
            if (value != null) {
                val result = sqrt(value)
                binding.tvResult.text = "√$value = $result"
                current = result.toString()
            } else {
                binding.tvResult.text = "Error"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
