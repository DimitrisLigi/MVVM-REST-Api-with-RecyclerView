package api

import models.UsersDomainModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import utils.Constants

interface ApiService {

    @GET("/api/users?page=1")
    suspend fun getUsers(): UsersDomainModel
}