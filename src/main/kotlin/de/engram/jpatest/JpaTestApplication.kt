package de.engram.jpatest

import de.engram.jpatest.model.organization.Organization
import de.engram.jpatest.model.organization.OrganizationRepository
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
  val userRepository: UserRepository,
  @Autowired
  val organizationRepository: OrganizationRepository
) : CommandLineRunner {
  @Transactional
  override fun run(vararg args: String?) {
    clearRepositories()

    val organization = Organization("test-org")
    organizationRepository.save(organization)

    val user = User("Testuser", organization)
    userRepository.save(user);

    organizationRepository.save(organization)
    println("org: $organization")
  }

  private fun clearRepositories() {
    if (userRepository.count() > 0) {
      userRepository.deleteAll()
    }
    if (organizationRepository.count() > 0) {
      organizationRepository.deleteAll()
    }
  }
}

fun main(args: Array<String>) {
  runApplication<JpaTestApplication>(*args)
}
