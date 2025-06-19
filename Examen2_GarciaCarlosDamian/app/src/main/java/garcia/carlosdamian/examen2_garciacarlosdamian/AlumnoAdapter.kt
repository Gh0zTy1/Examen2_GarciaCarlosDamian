package garcia.carlosdamian.examen2_garciacarlosdamian

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class AlumnoAdapter(
    private val context: Context,
    private val alumnos: MutableList<Alumno>
) : BaseAdapter() {

    override fun getCount() = alumnos.size
    override fun getItem(position: Int) = alumnos[position]
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.grind_item, parent, false)
        val alumni = alumnos[position]

        view.findViewById<TextView>(R.id.tvNombre).text = "${alumni.nombre} ${alumni.apellido}"
        view.findViewById<TextView>(R.id.tvCarrera).text = alumni.carrera
        view.findViewById<TextView>(R.id.tvCorreo).text = alumni.correoElectronico
        view.findViewById<TextView>(R.id.tvId).text = alumni.id

        view.findViewById<Button>(R.id.btnEditar).setOnClickListener {
            val intent = Intent(context, EditarAlumnoActivity::class.java).apply {
                putExtra("pos", position)
                putExtra("alumno", alumni)
            }
            context.startActivity(intent)
        }

        view.findViewById<ImageView>(R.id.btnEliminar).setOnClickListener {
            alumnos.removeAt(position)
            notifyDataSetChanged()
            Toast.makeText(context, "Alumno eliminado", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}