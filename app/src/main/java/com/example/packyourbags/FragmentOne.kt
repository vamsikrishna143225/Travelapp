package com.example.packyourbags

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider



class FragmentOne : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_one, container, false)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        var searchView = v.findViewById<SearchView>(R.id.scroll_1)

        val button = v.findViewById<Button>(R.id.btn_1)
        button.setOnClickListener {
            showToastMessage("Finding Best ride")
            val searchQuery = searchView.query.toString().trim()
            saveSearchQuery(searchQuery)
            sharedViewModel.setSearchQuery(searchQuery)
        }
        return v
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    private fun saveSearchQuery(query: String) {
        val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("searchQuery", query)
        editor.apply()
    }
}

