package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvAdapter: RecyclerAdapter
    var _binding: ActivityMainBinding? = null //defining the binding class
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(_binding!!.root)
        Constants.createPets()
        rvAdapter = RecyclerAdapter(context = this, petsList = Constants.createPets())
        _binding!!.rvPets.adapter = rvAdapter




    }
}