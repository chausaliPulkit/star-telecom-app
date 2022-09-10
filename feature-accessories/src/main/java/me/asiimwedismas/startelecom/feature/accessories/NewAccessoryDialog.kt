package me.asiimwedismas.startelecom.feature.accessories

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import me.asiimwedismas.startelecom.feature.accessories.databinding.NewAccessoryDialogBinding

class NewAccessoryDialog(
    @LayoutRes layout: Int = R.layout.new_accessory_dialog
) : DialogFragment(layout) {

    private val viewModel: AccessoryListViewModel by activityViewModels()
    private var _binding: NewAccessoryDialogBinding? = null
    private val binding get() = _binding!!

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            dialog.window!!.setLayout(width, height)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        isCancelable = false
        _binding = NewAccessoryDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editAccessoryName.setText(viewModel.accessoryName.value)

        binding.buttonCancelDialog.setOnClickListener {
            viewModel.closeNewAccessoryDialog()
        }
        binding.buttonSaveAccessory.setOnClickListener {
            viewModel.saveNewAccessory()
        }
        binding.editAccessoryName.doAfterTextChanged {
            viewModel.newAccessoryNameChanged(it.toString())
        }

        viewModel.showNewAccessoryDialog.observe(viewLifecycleOwner) { shouldShowDialog ->
            if (!shouldShowDialog)
                dismiss()
        }
        viewModel.accessoryName.observe(viewLifecycleOwner){
            binding.buttonSaveAccessory.isEnabled = it.isNotBlank()
        }

        viewModel.errorNewAccessory.observe(viewLifecycleOwner){
            if(it.isNotBlank()){
                binding.textInputLayout.error = it
            }else{
                binding.textInputLayout.error = null
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        val TAG = NewAccessoryDialog::class.simpleName
    }
}