package waslim.binar.andlima.challengech06v10.viewmodel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import waslim.binar.andlima.challengech06v10.model.datauser.DataUserResponseItem
import waslim.binar.andlima.challengech06v10.model.datauser.PostRequest
import waslim.binar.andlima.challengech06v10.model.datauser.PutRequest
import waslim.binar.andlima.challengech06v10.network.ApiClient
import waslim.binar.andlima.challengech06v10.network.ApiService
import javax.inject.Inject

@HiltViewModel
class ViewModelUser @Inject constructor(apiService: ApiService) : ViewModel(){

    private val userLogin = MutableLiveData<List<DataUserResponseItem>>()
    val login : LiveData<List<DataUserResponseItem>> = userLogin

    init {
        viewModelScope.launch {
            val dataLogin = apiService.getDataUser()

            userLogin.value = dataLogin
        }
    }

}