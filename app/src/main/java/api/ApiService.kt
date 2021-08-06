package api

import models.UsersDomainModel
import retrofit2.http.GET
import utils.Constants

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getUsers(): UsersDomainModel
}