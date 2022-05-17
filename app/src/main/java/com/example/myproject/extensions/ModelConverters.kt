package com.example.myproject.extensions

import com.example.myproject.data.models.UserDto
import com.example.myproject.data.models.UserEntity
import com.example.myproject.domain.models.User


fun UserDto.toUserEntity(): UserEntity {
    return UserEntity(
        id,
        name,
        surname
    )
}


fun UserDto.toUser(): User {
    return User(
        id,name,surname
    )
}