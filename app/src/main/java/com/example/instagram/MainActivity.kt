package com.example.instagram

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.instagram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibttnEditName.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 1)
        }

        binding.bttnLogin.setOnClickListener {
            if (binding.etLogin.text.toString() == "kunichh" && binding.etPassword.text.toString() == "6497") {
                binding.llLogin.isVisible = false
            }
            else
                binding.tvWrongData.text = "Невірні данні!"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            binding.tvName.text = data?.getStringExtra("username")
    }
}