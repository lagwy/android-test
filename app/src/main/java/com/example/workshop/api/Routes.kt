package com.example.workshop.api

import com.example.workshop.api.models.CharacterListResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface Routes {

    @GET("characters")
    fun getCharacters() : Observable<CharacterListResponse>

}