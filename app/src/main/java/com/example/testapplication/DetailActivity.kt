package com.example.testapplication

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.testapplication.databinding.ActivityDetailBinding
import com.example.testapplication.databinding.ActivityMainBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var userPostData = intent.getParcelableExtra("UserData",User::class.java)

        if(userPostData != null){
            with(binding){
                tvPostTitle.text = userPostData.title
                tvTitle.text = userPostData.detail
                tvPrice.text = DecimalFormat("#,###").format(userPostData.price).toString() + "원"
                tvUserId.text = userPostData.userId
                tvAddress.text = userPostData.address
                ivProfile.setImageResource(userPostData.profile)
            }
        }

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}