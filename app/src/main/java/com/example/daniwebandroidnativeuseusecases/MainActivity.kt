package com.example.daniwebandroidnativeuseusecases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Gets the button reference
        val button = findViewById<Button>(R.id.button_loadNext)

        button.setOnClickListener {
            //Calls ViewModel function after button click
            mainActivityViewModel.loadNext()
        }

        //Gets reference to the three TextView Views
        val item1 = findViewById<TextView>(R.id.textView_item1)
        val item2 = findViewById<TextView>(R.id.textView_item2)
        val item3 = findViewById<TextView>(R.id.textView_item3)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                mainActivityViewModel.stateFlow.collect {
                    item1.text = it.item1
                    item2.text = it.item2
                    item3.text = it.item3
                }
            }
        }
    }
}