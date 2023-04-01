package com.example.raioninternship.data

data class Project(val name: String,
                   val client: String,
                   val location: String,
                   val duration: String,
                   val crew: Int,
                   val royalty: Int,
                   val description: String,
                   val requirement: ArrayList<String>
)
