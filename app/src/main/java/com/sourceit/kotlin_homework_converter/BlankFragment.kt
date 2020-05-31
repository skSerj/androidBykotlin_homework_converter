package com.sourceit.kotlin_homework_converter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
                selectedUnit = saveInputToConvertParameters(position)
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
                txt_result.text = convertNum(selectedUnit, inputNum, position).toString()
            }
        }
    }
}


