package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.model.Comments
import com.example.testapp.network.CommentsRetriver
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val commentsRetriver : CommentsRetriver = CommentsRetriver()
    var _binding: ActivityMainBinding? = null //defining the binding class
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(_binding!!.root)
        fetchData()

    }

    private fun fetchData() {
        val fetchJob = Job()
        val errorHandler = CoroutineExceptionHandler{coroutineContext, throwable ->
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
        }
        val scope = CoroutineScope(fetchJob + Dispatchers.Main)
        scope.launch(errorHandler) {
            val comments = commentsRetriver.getComments()
            renderData(comments)
        }

    }

    private fun renderData(list: List<Comments>){
        _binding!!.rvPets.adapter = RecyclerAdapter(this,list)

    }
}