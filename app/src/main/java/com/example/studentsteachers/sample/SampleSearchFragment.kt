package com.example.studentsteachers.sample

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studentsteachers.R

class SampleSearchFragment : Fragment() {

    companion object {
        fun newInstance() = SampleSearchFragment()
    }

    private lateinit var viewModel: SampleSearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sample_search_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SampleSearchViewModel::class.java)
        // TODO: Use the ViewModel
    }

}