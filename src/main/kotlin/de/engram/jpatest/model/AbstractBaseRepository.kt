package de.engram.jpatest.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
interface AbstractBaseRepository<T>: JpaRepository<T, UUID>
