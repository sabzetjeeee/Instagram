package com.example.instagram

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bttnSave.setOnClickListener {
            var resultIntent = Intent(this, MainActivity::class.java)
            resultIntent.putExtra("username", binding.etName.text.toString() + " " + binding.etSurname.text.toString())
            setResult(1, resultIntent)
            finish()
        }
    }
}