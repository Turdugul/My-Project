package com.example.myproject.domain.use_cases

import com.example.myproject.data.repo.UserRepo
import com.example.myproject.domain.models.User
import com.example.myproject.extensions.toUser
import com.example.myproject.extensions.toUserEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepo: UserRepo
) {

    operator fun invoke(): Single<List<User>> {
        return userRepo.getUserFromApi()
            .subscribeOn(Schedulers.io())
            .map {
                userRepo.saveUsersToDb(it.map { it.toUserEntity() })
                it.map { it.toUser() }
            }
            .observeOn(AndroidSchedulers.mainThread())

    }
}