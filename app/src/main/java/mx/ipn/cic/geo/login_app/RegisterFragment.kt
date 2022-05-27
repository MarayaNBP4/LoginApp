package mx.ipn.cic.geo.login_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import mx.ipn.cic.geo.login_app.databinding.FragmentRegisterBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCrearCuenta.setOnClickListener {
            val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.createUserWithEmailAndPassword(binding.editEmail.text.toString(), binding.editPassword.text.toString()).addOnCompleteListener {
                if(it.isSuccessful) {
                    //Toast.makeText(RegisterFragment.this, "Registro adecuado", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_RegisterFragment_to_LoginFragment)
                }
                else {
                    Toast.makeText(activity, "No se pudo registrar al usuario", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_RegisterFragment_to_LoginFragment)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}
