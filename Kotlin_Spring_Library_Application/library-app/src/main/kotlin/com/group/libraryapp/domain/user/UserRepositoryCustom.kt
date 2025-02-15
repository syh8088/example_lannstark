package com.group.libraryapp.domain.user

interface UserRepositoryCustom {

    fun selectAllWithHistories(): List<User>
}