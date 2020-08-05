package com.example.workshop.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workshop.R
import com.example.workshop.adapters.CharacterAdapter
import com.example.workshop.api.models.Character
import com.example.workshop.api.models.World
import com.example.workshop.ui.base.BaseActivity
import com.example.workshop.ui.next.NextActivity

class MainActivity : BaseActivity<mView, Presenter>(), mView {

    override var presenter: Presenter = MainPresenter()

    private var adapter : CharacterAdapter? = null
    private var items = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.et_name)
        val btnClick = findViewById<Button>(R.id.btn_click)
        val btnActivity = findViewById<Button>(R.id.btn_activity)

        btnClick.setOnClickListener {
            Toast.makeText(this, etName.text.toString(), Toast.LENGTH_SHORT).show()
        }

        btnActivity.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            intent.putExtra("param", "Hola actividad")
            intent.putExtra("object", Character(50, "ED", World("Carnera")) )
            startActivity(intent)
        }

        val rvCharacters = findViewById<RecyclerView>(R.id.rv_characters)
        rvCharacters.layoutManager = LinearLayoutManager(this)
        adapter = CharacterAdapter(items, this)
        rvCharacters.adapter = adapter

        presenter.getCharacters()
    }

    override fun setCharacters(characters: ArrayList<Character>) {
        items.addAll(characters)
        adapter?.notifyDataSetChanged()
    }

    override fun showError(error: Throwable) {
        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
    }

}