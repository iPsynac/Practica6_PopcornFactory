package mx.edu.potro.practica6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class detalle_pelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val iv_pelicula_image: ImageView = findViewById(R.id.iv_pelicula_imagen)
        val tv_nombre_pelicula: TextView = findViewById(R.id.tv_nombre_pelicula)
        val tv_pelicula_desc: TextView = findViewById(R.id.tv_pelicula_desc)
        val seatsLefts : TextView = findViewById(R.id.seatLeft)
        val buyTickets : Button = findViewById(R.id.buyTickets)

        val bundle=intent.extras
        var ns = 0
        var id = -1
        var title=""

        if (bundle!=null){
            ns = bundle.getInt("numberSeats")
            title = bundle.getString("titulo").toString()
            iv_pelicula_image.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("titulo"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))
            seatsLefts.setText("$ns Seats Available")
            id = bundle.getInt("pos")

        }

        if (ns==0){
            println("No hay")
            buyTickets.isActivated = false
        }else{
            buyTickets.setOnClickListener{
                var intent : Intent = Intent(this,SeatSelection::class.java)
                buyTickets.isActivated=true
                if (bundle != null) {
                    intent.putExtra("id",id)
                    intent.putExtra("name",title)
                    this.startActivity(intent)
                }
            }
        }
    }
}