package waslim.binar.andlima.challengech06v10.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import waslim.binar.andlima.challengech06v10.model.datauser.DataUserResponseItem
import waslim.binar.andlima.challengech06v10.model.datauser.PostRequest
import waslim.binar.andlima.challengech06v10.network.ApiClient

class ViewModelRegister : ViewModel() {
    var liveDataUserRegister : MutableLiveData<DataUserResponseItem?> = MutableLiveData()

    fun getLiveRegister() : MutableLiveData<DataUserResponseItem?> {
        return liveDataUserRegister
    }


    fun makeApiRegister(username : String, email : String, password : String){
        ApiClient.instance.postDataUser(PostRequest(email, password, username))
            .enqueue(object : Callback<DataUserResponseItem> {
                override fun onResponse(
                    call: Call<DataUserResponseItem>,
                    response: Response<DataUserResponseItem>
                ) {
                    if (response.isSuccessful){
                        liveDataUserRegister.postValue(response.body())
                    } else {
                        liveDataUserRegister.postValue(null)
                    }
                }

                override fun onFailure(call: Call<DataUserResponseItem>, t: Throwable) {
                    liveDataUserRegister.postValue(null)
                }

            })
    }
}