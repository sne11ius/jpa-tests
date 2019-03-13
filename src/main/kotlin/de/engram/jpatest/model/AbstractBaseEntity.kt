package de.engram.jpatest.model

import au.com.console.kassava.kotlinEquals
import java.util.*
import java.util.Objects.hash
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractBaseEntity(
  @Id
  @Column(name = "id", updatable = false, nullable = false, columnDefinition = "binary(16)")
  val uuid: UUID = UUID.randomUUID()
) {
  companion object {
    protected val equalsProperties = arrayOf(AbstractBaseEntity::uuid)
  }

  final override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsProperties)
  final override fun hashCode() = hash(uuid)
}
