package com.example.gymapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gymapp.databinding.FragmentWorkoutExecutionBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class WorkoutExecutionFragment : Fragment() {

    private var _binding: FragmentWorkoutExecutionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkoutExecutionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBottomSheet()
        setupClickListeners()
    }

    private fun setupBottomSheet() {
        val bottomSheetView = binding.layoutWorkoutQueue.root
        val behavior = BottomSheetBehavior.from(bottomSheetView)
        
        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // Lógica de mudança de estado
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }

    private fun setupClickListeners() {
        binding.btnAddWeight.setOnClickListener {
            val currentWeight = binding.etWeight.text.toString().toDoubleOrNull() ?: 0.0
            binding.etWeight.setText((currentWeight + 2.5).toString())
        }

        binding.btnMinusWeight.setOnClickListener {
            val currentWeight = binding.etWeight.text.toString().toDoubleOrNull() ?: 0.0
            if (currentWeight >= 2.5) {
                binding.etWeight.setText((currentWeight - 2.5).toString())
            }
        }

        binding.btnCompleteSet.setOnClickListener {
            // Lógica para salvar a série
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
