package com.example.instagram

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.instagram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val SELECT_PICTURE = 111
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

        binding.ivAvatar.setOnClickListener {
            imageChooser();
        }
    }

    fun imageChooser() {
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1){
            binding.tvName.text = data?.getStringExtra("username")
        }

        if (requestCode == SELECT_PICTURE) {
            // Get the url of the image from data
            val selectedImageUri: Uri? = data?.data
            if (null != selectedImageUri) {
                // update the preview image in the layout
                binding.ivAvatar.setImageURI(selectedImageUri)
            }
        }
    }
}

