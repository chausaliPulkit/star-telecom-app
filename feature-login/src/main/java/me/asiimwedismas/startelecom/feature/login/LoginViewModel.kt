package me.asiimwedismas.startelecom.feature.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.asiimwedismas.startelecom.core.common.Resource
import me.asiimwedismas.startelecom.core.data.repository.StaffMemberRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val staffMemberRepository: StaffMemberRepository
) : ViewModel() {

    private val _credentialsUI = MutableLiveData(CredentialsFragUI())
    val credentialsUI: LiveData<CredentialsFragUI> = _credentialsUI
    
    private val _result = MutableLiveData<String>("")
    val result: LiveData<String> = _result

    fun onEditUsername(username: String) {
        _credentialsUI.value = _credentialsUI.value?.copy(username = username)
    }

    fun onEditPassword(password: String) {
        _credentialsUI.value = _credentialsUI.value?.copy(password = password)
    }

    private var authenticateJob: Job? = null
    fun authenticateUser() {
        _credentialsUI.value = _credentialsUI.value?.copy(isSearchingForUser = true)
        authenticateJob?.cancel()
        authenticateJob = viewModelScope.launch {
            _credentialsUI.value?.let {
                staffMemberRepository.authenticateUser(it.username!!, it.password!!).run {
                    when(this){
                        is Resource.Success ->{
                            if (data == null){
                                _result.value = "Invalid username or password"
                            }
                            else{
                                _result.value = data!!.full_name
                            }
                        }
                        is Resource.Error ->{
                            _result.value = this.message!!
                        }
                    }
                }
            }
        }
    }
}