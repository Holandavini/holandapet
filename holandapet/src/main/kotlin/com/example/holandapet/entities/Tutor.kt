package com.example.holandapet.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "tutor")
class Tutor {
    @field:Id
    @field: GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @field:NotNull
    @field:Size(min = 1,max = 50)
    var nome: String = ""

    @field:NotNull
    @field:Size(min = 10, max = 11)
    var contato: String = ""

    @field:NotNull
    @field:Size(min = 1, max = 255)
    var animal: ArrayList<String> = arrayListOf()

}