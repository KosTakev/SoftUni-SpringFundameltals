package com.example.kotlin.service

import org.springframework.stereotype.Service

@Service
class GreeterService {

    fun generateGreeting(name: String) : String {
        return "Hello $name"
    }
}