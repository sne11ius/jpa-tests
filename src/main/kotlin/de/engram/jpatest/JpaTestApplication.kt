package de.engram.jpatest

import de.engram.jpatest.model.user.User
import de.engram.jpatest.model.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.transaction.annotation.Transactional

@SpringBootApplication
class JpaTestApplication(
  @Autowired
  val userRepository: UserRepository
): CommandLineRunner {
  @Transactional
  override fun run(vararg args: String?) {
    if (userRepository.count() > 0) {
      userRepository.deleteAll()
    }
    val user = User(name = "Testuser")
    userRepository.save(user)
  }
}

fun main(args: Array<String>) {
	runApplication<JpaTestApplication>(*args)
}
