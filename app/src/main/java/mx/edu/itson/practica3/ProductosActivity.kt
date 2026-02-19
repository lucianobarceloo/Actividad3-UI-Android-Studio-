package mx.edu.itson.practica3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
class ProductosActivity : AppCompatActivity() {

    var menu : ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)

        val imagenHeader: ImageView = findViewById(R.id.imageView)

        var menuOption: String? = intent.getStringExtra("menuType")

        addProducts(menuOption, imagenHeader)

        var listview : ListView = findViewById<ListView>(R.id.listview)
        var adaptador : AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun addProducts(option: String?, imagenHeader: ImageView){

        when(option){
            "Antojitos" -> {
                // Cambiamos la imagen del encabezado
                imagenHeader.setImageResource(R.drawable.antojitos)

                menu.add(Product("Quesadillas", R.drawable.quesadillas, "Rellenas con su carne favorita, servidas con ensalada.", 6.29))
                menu.add(Product("Huaraches", R.drawable.huaraches, "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema.", 11.49))
                menu.add(Product("Gringas", R.drawable.gringas, "Tortilla de harina con queso, carne al pastor y piña.", 8.39))
                menu.add(Product("Sincronizada", R.drawable.sincronizadas, "Tortilla de harina rellena con queso y jamón. Acompañada de lechuga, crema y guacamole.", 7.99))
                menu.add(Product("Sopes", R.drawable.sopes, "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema.", 3.99))
                menu.add(Product("Tostadas", R.drawable.tostadas, "Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate.", 4.59))
            }
            "Especialidades" -> {
                imagenHeader.setImageResource(R.drawable.especialidades)

                menu.add(Product("Mojarra Frita", R.drawable.mojarra, "Tilapia frita servida con lechuga, cebolla, jitomate, aguacate y tortillas.", 17.99))
                menu.add(Product("Ceviche", R.drawable.ceviche, "Tilapia, camarones, aguacate y pico de gallo servido con chips.", 6.99))
                menu.add(Product("Botana De Camarones Al Mojo de Ajo", R.drawable.botanacamarones, "", 19.99))
                menu.add(Product("Coctel de Camarón", R.drawable.coctel, "Camarón,pulpo, pico de gallo, aguacate, limón and salsa de coctel. Servida fría.", 17.99))
            }
            "Combinaciones" -> {
                imagenHeader.setImageResource(R.drawable.combinations)

                menu.add(Product("Traditional Taco Combo", R.drawable.combinationtaco, "Tortilla de maíz y tu carne favorita. Servido con arroz y frijoles.", 6.99))
                menu.add(Product("Mexican Burritos", R.drawable.cominationburros, "Tu carne favorita en una tortilla grande de harina rellena con cebolla frita, pico de gallo, sour cream, frijoles y acompañado de arroz.", 13.69))
                menu.add(Product("Los Portales Burrito", R.drawable.burritosportales, "Large flour tortilla filled with grilled cactus, steak, pastor (seasoned pork), grilled onions, rice and beans.", 14.59))
                menu.add(Product("Cinco", R.drawable.cinco, "One hard sell taco with your choice of meat, lettuce and cheese.", 10.99))
                menu.add(Product("Dos Amigos", R.drawable.dosamigos, "Two hard shell tacos with your choice of meat topped with lettuce and shredded cheese.", 10.99))
                menu.add(Product("Burrito Pepe", R.drawable.burritopepe, "Flour tortilla filled with your choice of meat with beans, lettuce, sour cream, guacamole and pico de gallo.", 10.99))
                menu.add(Product("Fajita Quesadilla", R.drawable.fajitaquesadilla, "Flour tortilla filled with your choice of meat with beans, lettuce, sour cream, guacamole and pico de gallo.", 10.99))
            }
            "Tortas" -> {
                imagenHeader.setImageResource(R.drawable.tortas)

                menu.add(Product("Torta Regular", R.drawable.torta, "All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeno pepper and your choice of meat.", 13.39))
                menu.add(Product("Milanesa de Pollo Torta", R.drawable.tortamilanesa, "Chicken", 13.99))
                menu.add(Product("Torta Cubana", R.drawable.tortacubana, "Chorizo, asada, jamon, pastor y queso.", 14.49))
                menu.add(Product("Torta Mixta", R.drawable.tortamixta, "Chorizo, asada, y pastor.", 13.99))
                menu.add(Product("Small Mexican Torta", R.drawable.smallmexican, "Chorizo, asada, y pastor.", 13.99))
            }
            "Sopas" -> {
                imagenHeader.setImageResource(R.drawable.sopas)

                menu.add(Product("Caldo de Res", R.drawable.caldores, "Beef ribs and chuck stew with corn, potato, chayote (squash family), cabage, cilantro, onion, zuccini, carrots, lime, and tortillas.", 8.39))
                menu.add(Product("Pozole", R.drawable.pozole, "Pork ribs and bonston butt stew with homminy and oregano.", 7.99))
                menu.add(Product("Menudo", R.drawable.menudo, "Ancestral broth, silky tripe, come together in a bowl that tastes like Sunday mornings, family kitchens, and stories passed down through generations.", 13.99))
                menu.add(Product("Caldo de Camarón", R.drawable.caldocamaron, "Shrimp soup.", 13.99))
                menu.add(Product("Sopa de Mariscos", R.drawable.sopamariscos, "Seafood soup.", 13.99))
            }
            "Bebidas" -> {
                imagenHeader.setImageResource(R.drawable.drinks)

                menu.add(Product("Jarritos", R.drawable.jarritos, "", 2.75))
                menu.add(Product("Cerveza", R.drawable.domesticbeer, "", 5.49))
                menu.add(Product("Caguama", R.drawable.caguama, "", 5.49))
                menu.add(Product("Caguama Michelada", R.drawable.caguamamichelada, "", 5.49))
                menu.add(Product("Sodas", R.drawable.sodas, "", 2.49))
                menu.add(Product("Michelada", R.drawable.michelada, "", 5.49))
                menu.add(Product("Cubetazo", R.drawable.cubetazo, "", 5.49))
                menu.add(Product("Cubeta Six", R.drawable.cubetasix, "", 5.49))
            }
        }
    }

    private class AdaptadorProductos: BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto: Context, productos: ArrayList<Product>){
            this.productos = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any? {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?
        ): View? {
            var producto = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById<ImageView>(R.id.producto_img)
            var nombre = vista.findViewById<TextView>(R.id.producto_nombre)
            var desc = vista.findViewById<TextView>(R.id.producto_desc)
            var precio = vista.findViewById<TextView>(R.id.producto_precio)

            imagen.setImageResource(producto.image)
            nombre.setText(producto.name)
            desc.setText(producto.description)
            precio.setText("${producto.price}")
            return vista

        }
    }
}