package mx.ipn.cic.geo.login_app

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import mx.ipn.cic.geo.login_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        this.supportActionBar?.hide()

         //Realizar una prueba de conexión.
         //Write a message to the database
//         val database = FirebaseDatabase.getInstance()
//         val referencia = database.getReference("mensaje_app")
//
//         referencia.setValue("Aplicación conectada a Firebase")

//        var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
//
//        firebaseAuth.createUserWithEmailAndPassword("jose.guzman@gmail.com", "otro_password_sencillo").addOnCompleteListener {
//            if(it.isSuccessful) {
//                Toast.makeText(applicationContext, "Registro adecuado", Toast.LENGTH_LONG).show()
//            }
//            else {
//                Toast.makeText(applicationContext, "No se pudo registrar al usuario", Toast.LENGTH_LONG).show()
//            }
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}