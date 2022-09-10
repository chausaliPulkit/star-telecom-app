package me.asiimwedismas.startelecom.feature.accessories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.asiimwedismas.startelecom.core.data.repository.AccessoryRepository
import me.asiimwedismas.startelecom.core.model.Accessory
import javax.inject.Inject

@HiltViewModel
class AccessoryListViewModel @Inject constructor(
    private val accessoryRepository: AccessoryRepository
) : ViewModel() {

    val accessories: LiveData<List<Accessory>> = MutableLiveData(
        mutableListOf(
            Accessory(name = "Charger"),
            Accessory(name = "Battery"),
            Accessory(name = "Flash 4gb"),
        )
    )

    private val _showNewAccessoryDialog = MutableLiveData(false)
    val showNewAccessoryDialog: LiveData<Boolean> = _showNewAccessoryDialog

    private val _errorNewAccessory = MutableLiveData<String>("")
    val errorNewAccessory: LiveData<String> = _errorNewAccessory

    private val _accessoryName = MutableLiveData<String>("")
    val accessoryName: LiveData<String> = _accessoryName

    fun onAccessoryClicked(accessory: Accessory) {

    }

    fun newAccessoryNameChanged(entry: String) {
        _accessoryName.value = entry
    }

    fun showAddAccessoryDialog() {
        _showNewAccessoryDialog.value = true
    }

    fun closeNewAccessoryDialog() {
        _showNewAccessoryDialog.value = false
    }

    fun deleteAccessory(swipedAccessory: Accessory) {
        viewModelScope.launch {
            accessoryRepository.deleteAccessory(swipedAccessory)
        }
    }

    fun saveNewAccessory() {
        accessoryName.value?.let {
            if (it.isBlank()) {
                _errorNewAccessory.value = "Accessory can't be blank"
                return
            }

            val isPresent = accessories.value?.find { listAccessory ->
                listAccessory.name.equals(it, true)
            }

            if (isPresent != null) {
                _errorNewAccessory.value = "Accessory already exists"
                return
            }

            viewModelScope.launch {
                accessoryRepository.saveAccessory(
                    Accessory(name = it)
                )
                _errorNewAccessory.value = ""
                _accessoryName.value = ""
                _showNewAccessoryDialog.value = false
            }
        }
    }
}