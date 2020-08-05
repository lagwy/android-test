package com.example.workshop.ui

import com.example.workshop.api.models.Character
import com.example.workshop.ui.base.BasePresenter
import com.example.workshop.ui.base.BaseView

interface mView: BaseView {
    fun setCharacters(characters : ArrayList<Character>)
    fun showError(error: Throwable)
}

interface Presenter : BasePresenter<mView> {
    fun getCharacters()
}