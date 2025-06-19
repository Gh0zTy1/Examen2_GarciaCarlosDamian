package garcia.carlosdamian.examen2_garciacarlosdamian

import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object{

        val listaAlumnos = mutableListOf(

            Alumno("0001","Carlos Damian","Garcia","Ingenieria en software","Caarlosberal13@gmail.com"),
            Alumno("0002","Leticia","Figueroa","Turismo","Caarlosberal13@gmail.com"),
            Alumno("0003","Oralia","Perez","Maketing","Caarlosberal13@gmail.com"),
            Alumno("0004","Jose Manuel","Quintero","LPW","Caarlosberal13@gmail.com"),
            Alumno("0005","Sebastian","Murrieta","OSL","Caarlosberal13@gmail.com"),
            Alumno("0006","Kevin","Bernal","PPW","Caarlosberal13@gmail.com"),
            Alumno("0007","Saul","Sanchez","WWS","Caarlosberal13@gmail.com"),
            Alumno("0008","Hector","Madero","LLS","Caarlosberal13@gmail.com"),
            Alumno("0009","Francisco","De la loma","GGS","Caarlosberal13@gmail.com"),
            Alumno("00010","Ezequiel","Mesa","LLOS","Caarlosberal13@gmail.com")




        )





    }

    override fun onResume() {
        super.onResume()

        (findViewById<GridView>(R.id.gridView).adapter as BaseAdapter).notifyDataSetChanged()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = AlumnoAdapter(this,listaAlumnos)

        }
    }
