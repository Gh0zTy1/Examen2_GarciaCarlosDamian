package garcia.carlosdamian.examen2_garciacarlosdamian

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditarAlumnoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_alumno)

        val posicion = intent.getIntExtra("pos", -1)
        val alumno = intent.getSerializableExtra("alumno") as Alumno

        val editNombre = findViewById<EditText>(R.id.editNombre)
        val editApellido = findViewById<EditText>(R.id.editApellido)
        val editCarrera = findViewById<EditText>(R.id.editCarrera)
        val editCorreo = findViewById<EditText>(R.id.editCorreo)
        val editId = findViewById<EditText>(R.id.editId)


        editNombre.setText(alumno.nombre)
        editApellido.setText(alumno.apellido)
        editCarrera.setText(alumno.carrera)
        editCorreo.setText(alumno.correoElectronico)
        editId.setText(alumno.id)

        findViewById<Button>(R.id.btnGuardar).setOnClickListener {
            alumno.nombre = editNombre.text.toString()
            alumno.apellido = editApellido.text.toString()
            alumno.carrera = editCarrera.text.toString()
            alumno.correoElectronico = editCorreo.text.toString()
            alumno.id = editId.text.toString()

            Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}