package repository

import androidx.lifecycle.LiveData
import api.ApiBuilder
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import models.UsersDomainModel

object MainRepository {

    private var currentJob: CompletableJob? = null

    fun getUsers():LiveData<UsersDomainModel>{
        currentJob = Job()
        return object : LiveData<UsersDomainModel>(){
            override fun onActive() {
                super.onActive()
                currentJob?.let{
                    CoroutineScope(IO+it).launch {
                        val users = ApiBuilder.apiService.getUsers()
                        withContext(Main){
                            value = users
                            it.complete()
                        }
                    }
                }
            }
        }
    }


    fun cancelJobs(){
        currentJob?.cancel()
    }
}