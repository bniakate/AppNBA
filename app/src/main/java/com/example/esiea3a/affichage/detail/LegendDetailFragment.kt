package com.example.esiea3a.affichage.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.esiea3a.R
import com.example.esiea3a.affichage.Singletons
import com.example.esiea3a.affichage.api.LegendDetailResponse
import retrofit2.Call
import retrofit2.Response


class LegendDetailFragment : Fragment() {

    private lateinit var textViewName : TextView
    private lateinit var textViewConf : TextView
    private lateinit var textViewCity : TextView
    private lateinit var textViewDivi : TextView


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_legend_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.legend_detail_name)
        textViewConf = view.findViewById(R.id.legend_detail_conference)
        textViewCity= view.findViewById(R.id.legend_detail_city)
        textViewDivi = view.findViewById(R.id.legend_detail_division)
        callApi()
    }

    private fun callApi() {
        val id= arguments?.getInt("legendId") ?: -1
        Singletons.legendApi.getLegendDetail(id).enqueue(object : retrofit2.Callback<LegendDetailResponse>{
            override fun onResponse(
                call: Call<LegendDetailResponse>,
                response: Response<LegendDetailResponse>
            ) {   if(response.isSuccessful && response.body() !=null) {

                  textViewName.text = response.body()!!.full_name
                  textViewConf.text = response.body()!!.conference
                  textViewCity.text = response.body()!!.city
                  textViewDivi.text = response.body()!!.division

            }
            }

            override fun onFailure(call: Call<LegendDetailResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })


    }

}



