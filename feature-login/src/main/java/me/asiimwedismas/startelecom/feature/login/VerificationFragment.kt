package me.asiimwedismas.startelecom.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import me.asiimwedismas.startelecom.feature.login.databinding.FragmentVerificationBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class VerificationFragment : Fragment() {

    private var _binding: FragmentVerificationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentVerificationBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTextVerificationSMSCode.doAfterTextChanged {

        }

        binding.buttonVerifyCode.setOnClickListener {

        }

        binding.buttonChangeLoginCredentials.setOnClickListener {

        }

        binding.buttonRequestAnotherCode.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}