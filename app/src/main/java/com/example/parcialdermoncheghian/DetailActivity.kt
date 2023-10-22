package com.example.parcialdermoncheghian

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var ivimagenDetail: ImageView
    private lateinit var tvingDetail: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val receta = intent.getParcelableExtra<Receta>("receta")

        tvingDetail = findViewById(R.id.tv_ing_detail)
        ivimagenDetail = findViewById(R.id.imgdetail)

        if (receta == null) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            tvingDetail.text = receta.ingredientes.toString()
            Glide.with(this).load(receta?.image).into(ivimagenDetail)
        }
    }
}