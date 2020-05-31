package com.sourceit.kotlin_homework_converter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.fragment_blank.*

class BlankFragment : Fragment() {

    lateinit var selectedUnit: String


    companion object {
        fun newInstance() = BlankFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.Units_for_conversion,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spn_before_convert.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.converted_unit,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spn_after_convert.adapter = adapter
        }

        spn_before_convert.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                selectedUnit = when (position) {
                    0 -> "mm"
                    1 -> "sm"
                    2 -> "dm"
                    3 -> "m"
                    else -> "wrong"
                }
            }
        }

        spn_after_convert.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val inputNum = edt_input_num.text.toString().ifEmpty { "0" }.toDouble()
                when {
                    selectedUnit.contains("mm") -> {
                        val result = when (position) {
                            0 -> "wrong"
                            1 -> inputNum / 10
                            2 -> inputNum / 100
                            3 -> inputNum / 1000
                            else -> 0
                        }
                        txt_result.text = result.toString()
                    }
                    selectedUnit.contains("sm") -> {
                        val result = when (position) {
                            0 -> inputNum * 10
                            1 -> "wrong"
                            2 -> inputNum / 10
                            3 -> inputNum / 100
                            else -> 0
                        }
                        txt_result.text = result.toString()
                    }
                    selectedUnit.contains("dm") -> {
                        val result = when (position) {
                            0 -> inputNum * 100
                            1 -> inputNum * 10
                            2 -> "wrong"
                            3 -> inputNum / 10
                            else -> 0
                        }
                        txt_result.text = result.toString()
                    }
                    selectedUnit.contains("m") -> {
                        val result = when (position) {
                            0 -> inputNum * 1000
                            1 -> inputNum * 100
                            2 -> inputNum * 10
                            3 -> "wrong"
                            else -> 0
                        }
                        txt_result.text = result.toString()
                    }
                }
            }
        }
    }
}


