package com.github.xs93.mask.simple

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.github.xs93.mask.HighLightMask
import com.github.xs93.mask.HighLightPage
import com.github.xs93.mask.HighLightShapeType
import com.github.xs93.mask.simple.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        val page1 = HighLightPage.Builder()
            .touchOutsideCancel(false)
            .backgroundColor(Color.RED)
            .addHighLight(binding.textviewFirst, HighLightShapeType.CIRCLE, 100,20f) {
                Toast.makeText(requireContext(), "1111", Toast.LENGTH_SHORT).show()
            }
            .build()

        HighLightMask.showPage(requireActivity(), page1)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}