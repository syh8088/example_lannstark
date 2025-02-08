package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService,
) {


    @Test
    fun saveUserTest() {

        // given
        val request = UserCreateRequest("test", null)

        // when
        userService.saveUser(request)

        //then
        val findAll = userRepository.findAll()
        assertThat(findAll).hasSize(1)
        assertThat(findAll[0].name).isEqualTo("test")
        assertThat(findAll[0].age).isNull()
    }

}