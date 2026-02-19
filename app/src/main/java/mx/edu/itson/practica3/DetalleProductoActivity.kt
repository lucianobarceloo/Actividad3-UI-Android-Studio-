package mx.edu.itson.practica3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_prodcuto)

        // Recuperar el objeto enviado
        val producto = intent.getSerializableExtra("producto") as? Product

        if (producto != null) {
            val imagen: ImageView = findViewById(R.id.img_detalle)
            val nombre: TextView = findViewById(R.id.nombre_detalle)
            val desc: TextView = findViewById(R.id.desc_detalle)
            val precio: TextView = findViewById(R.id.precio_detalle)

            imagen.setImageResource(producto.image)
            nombre.text = producto.name
            desc.text = producto.description
            precio.text = "$${producto.price}"
        }
    }
}