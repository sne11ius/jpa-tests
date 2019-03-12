package de.engram.jpatest.model.user

import de.engram.jpatest.model.AbstractBaseEntity
import javax.persistence.Entity

@Entity
data class User(
  val name: String
) : AbstractBaseEntity()
