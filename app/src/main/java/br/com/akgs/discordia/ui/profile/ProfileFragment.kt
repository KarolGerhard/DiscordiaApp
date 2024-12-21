package br.com.akgs.discordia.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.akgs.discordia.databinding.FragmentPerfilBinding
import br.com.akgs.discordia.ui.login.LoginActivity
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null

    private val binding: FragmentPerfilBinding get() = _binding!!

    var id: String? = ""

    private val viewModel by sharedViewModel<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtNome.text = viewModel.currentUser().nome
        binding.txtEmail.text = viewModel.currentUser().email

        binding.btnSair.setOnClickListener {
            viewModel.signOut()
            val backToLogin = Intent(context, LoginActivity::class.java)
            startActivity(backToLogin)
            activity?.finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}