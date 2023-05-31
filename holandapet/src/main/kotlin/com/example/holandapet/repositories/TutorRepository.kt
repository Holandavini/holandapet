package com.example.holandapet.repositories

import com.example.holandapet.entities.Tutor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface TutorRepository: JpaRepository<Tutor, Long> {}