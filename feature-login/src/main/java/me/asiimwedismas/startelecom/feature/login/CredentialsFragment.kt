package me.asiimwedismas.startelecom.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import me.asiimwedismas.startelecom.feature.login.databinding.FragmentCredentialsBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class CredentialsFragment : Fragment() {

    private var _binding: FragmentCredentialsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCredentialsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickListeners()
        setObservers()
    }

    private fun setObservers() {
        viewModel.credentialsUI.observe(viewLifecycleOwner) {
            binding.editTextUsername.isEnabled = it.canEditCredentials
            binding.editTextPassword.isEnabled = it.canEditCredentials
            binding.buttonLogin.isEnabled = it.isSignInButtonEnabled
            binding.layoutProgressIndicator.visibility =
                if (it.isSearchingForUser) View.VISIBLE else View.GONE
        }

        viewModel.result.observe(viewLifecycleOwner){
            binding.textviewProgressMessage.text = it
        }
    }

    private fun setClickListeners() {
        binding.editTextUsername.doAfterTextChanged {
            viewModel.onEditUsername(it.toString())
        }

        binding.editTextPassword.doAfterTextChanged {
            viewModel.onEditPassword(it.toString())
        }

        binding.buttonLogin.setOnClickListener {
            viewModel.authenticateUser()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}