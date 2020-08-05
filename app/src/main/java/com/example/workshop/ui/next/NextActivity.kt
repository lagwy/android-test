package com.example.workshop.ui.next

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.workshop.R
import com.example.workshop.api.models.Character

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_character_detail)

        val text = findViewById<TextView>(R.id.tv_text)

        val objectParam : Character =  intent.extras!!.get("object") as Character
        text.text = objectParam.vocation
    }

}