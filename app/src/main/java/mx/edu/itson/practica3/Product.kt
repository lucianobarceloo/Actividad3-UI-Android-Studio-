package mx.edu.itson.practica3

import java.io.Serializable

data class Product(
    var name: String,
    var image: Int,
    var description: String,
    var price: Double
) : Serializable