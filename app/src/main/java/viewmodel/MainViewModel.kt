package viewmodel

import repository.MainRepository

class MainViewModel {

    val listOfUsers = MainRepository.getUsers()
}