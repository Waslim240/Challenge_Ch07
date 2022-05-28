package waslim.binar.andlima.challengech06v10.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import waslim.binar.andlima.challengech06v10.model.datauser.DataUserResponseItem
import waslim.binar.andlima.challengech06v10.model.datauser.PutRequest
import waslim.binar.andlima.challengech06v10.network.ApiClient

class ViewModelUpdate : ViewModel() {
    var liveDataUserUpdate : MutableLiveData<List<DataUserResponseItem>?> = MutableLiveData()

    fun getLiveUpdate() : MutableLiveData<List<DataUserResponseItem>?> {
        return liveDataUserUpdate
    }

    fun makeApiUpdate(id : String, address : String, dateOfBirth : String, fullName : String, image : String, username : String){
        ApiClient.instance.updateDataUser(id, PutRequest(address, dateOfBirth, fullName, image, username))
            .enqueue(object : Callback<List<DataUserResponseItem>> {
                override fun onResponse(
                    call: Call<List<DataUserResponseItem>>,
                    response: Response<List<DataUserResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataUserUpdate.postValue(response.body())
                    } else {
                        liveDataUserUpdate.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<DataUserResponseItem>>, t: Throwable) {
                    liveDataUserUpdate.postValue(null)
                }

            })
    }
}