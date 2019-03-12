package de.engram.jpatest.model

import au.com.console.kassava.kotlinEquals
import java.util.*
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractBaseEntity {
  @Id
  @Column(name = "id", updatable = false, nullable = false, columnDefinition = "binary(16)")
  val id = UUID.randomUUID()

  companion object {
    private val equalsProperties = arrayOf(AbstractBaseEntity::id)
  }

  override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsProperties)
}
