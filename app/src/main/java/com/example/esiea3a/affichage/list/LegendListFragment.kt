package com.example.esiea3a.affichage.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LegendListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loader: ProgressBar
    private lateinit var textViewError: TextView

    private val adapter = LegendAdapter(listOf(), ::onClickedLegend)

    private val viewModel : LegendListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_legend_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.legend_recyclerview)
        loader = view.findViewById(R.id.legend_loader)
        textViewError = view.findViewById(R.id.legend_error)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@LegendListFragment.adapter
        }
        viewModel.legendList.observe(viewLifecycleOwner, Observer {legendModel ->
            loader.isVisible = legendModel is LegendLoader
            textViewError.isVisible = legendModel is LegendError

            if(legendModel is LegendSuccess){
                adapter.updateList(legendModel.legendList)
            }

        })

    }


    private fun onClickedLegend(id: Int) {
        findNavController().navigate(
            R.id.navigateToLegendDetailFragment, bundleOf(
                "legendId" to (id + 1)
            )
        )
    }


}

