package viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import models.UsersDomainModel
import repository.MainRepository

class MainViewModel: ViewModel() {


    val users = MainRepository.getUsers()

    fun cancelJobs(){
        MainRepository.cancelJobs()
    }
}