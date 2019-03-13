package de.engram.jpatest.model.user

import au.com.console.kassava.kotlinToString
import de.engram.jpatest.model.AbstractBaseEntity
import de.engram.jpatest.model.organization.Organization
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class User(
  var name: String,
  organization: Organization
) : AbstractBaseEntity() {

  @ManyToOne
  private var _organization: Organization

  val organization: Organization
    get() = _organization

  init {
    _organization = organization
    _organization.addUser(this)
  }

  fun addToOrganisation(organization: Organization) {
    if (organization != _organization) {
      _organization = organization
      _organization.addUser(this)
    }
  }

  companion object {
    val toStringProperties = arrayOf(User::name)
  }

  override fun toString() = kotlinToString(toStringProperties)
}
