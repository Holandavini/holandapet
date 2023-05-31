package com.example.holandapet.controllers

import com.example.holandapet.entities.Tutor
import com.example.holandapet.repositories.TutorRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/registro")
class TutorController {
    @Autowired
    lateinit var repository: TutorRepository

    @PostMapping()
    fun createTutor(@RequestBody tutor: Tutor): Tutor {
        return repository.save(tutor)
    }

    @GetMapping()
    fun getAllTutors(): List<Tutor> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun getTutorById(@PathVariable("id") id: Long): Tutor {
        return repository.findById(id).orElseThrow { EntityNotFoundException() }
    }

    @PutMapping("/{id}")
    fun updateTutor(@PathVariable("id") id: Long, @RequestBody novoTutor: Tutor): Tutor {
        val tutor = repository.findById(id).orElseThrow { EntityNotFoundException() }
        tutor.apply {
            this.nome = novoTutor.nome
            this.contato = novoTutor.contato
            for (animal in novoTutor.animal){
                if (animal !in this.animal){
                    this.animal.add(animal)
                }
            }
        }
        repository.save(tutor)
        return tutor
    }

    @DeleteMapping("/{id}")
    fun deleteTutorById(@PathVariable("id") id: Long) {
        val tutor = repository.findById(id).orElseThrow { EntityNotFoundException() }
        return repository.delete(tutor)
    }
}