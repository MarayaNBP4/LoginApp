package mx.ipn.cic.geo.login_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.ipn.cic.geo.login_app.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCrearCuenta.setOnClickListener {
            // Acción para crear cuenta.
            findNavController().navigate(R.id.action_LoginFragment_to_RegisterFragment)
        }
        // Se agrega el listener para el action de mostrar el mapa.
        binding.buttonIniciarSesion.setOnClickListener {
            // TODO: Agregar validación del nombre de usuario y contraseña (Firebase).
            findNavController().navigate(R.id.action_LoginFragment_to_MapsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}