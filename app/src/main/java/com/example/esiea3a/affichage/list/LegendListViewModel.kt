package com.example.esiea3a.affichage.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.esiea3a.affichage.Singletons
import com.example.esiea3a.affichage.api.LegendListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LegendListViewModel : ViewModel(){
     val legendList: MutableLiveData<LegendModel> = MutableLiveData()

    init{
        callApi()
    }

    private fun callApi() {
        legendList.value = LegendLoader
        Singletons.legendApi.getLegendList().enqueue(object : Callback<LegendListResponse> {
            override fun onFailure(call: Call<LegendListResponse>, t: Throwable) {
                legendList.value = LegendError
            }

            override fun onResponse(
                call: Call<LegendListResponse>,
                response: Response<LegendListResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val legendResponse: LegendListResponse = response.body()!!
                    legendList.value = LegendSuccess(legendResponse.data)
                    //adapter.updateList(legendResponse.data)

                } else{
                    legendList.value = LegendError
                }


            }


        })
    }

}