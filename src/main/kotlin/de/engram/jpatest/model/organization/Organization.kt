package de.engram.jpatest.model.organization

import au.com.console.kassava.kotlinToString
import de.engram.jpatest.model.AbstractBaseEntity
import de.engram.jpatest.model.user.User
import java.util.Collections.unmodifiableSet
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class Organization(
  var name: String
) : AbstractBaseEntity() {

  @OneToMany(mappedBy = "_organization")
  private val _users: MutableSet<User> = mutableSetOf()

  val users: Set<User>
    get() = unmodifiableSet(_users)

  fun addUser(user: User) {
    if (user !in this._users) {
      this._users += user
      user.addToOrganisation(this)
    }
  }

  companion object {
    val toStringProperties = arrayOf(Organization::name, Organization::users)
  }

  override fun toString() = kotlinToString(toStringProperties)
}

