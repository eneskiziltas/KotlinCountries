package com.eneskiziltas.kotlincountries3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.eneskiziltas.kotlincountries3.view.CountryFragmentArgs
import com.eneskiziltas.kotlincountries3.R
import com.eneskiziltas.kotlincountries3.util.downoadFromUrl
import com.eneskiziltas.kotlincountries3.util.placeholderProgressBar
import com.eneskiziltas.kotlincountries3.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {

    private lateinit var viewModel : CountryViewModel

    private var countryUuid = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUuid
        }

        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuid)

        observeLiveData()


    }

    private fun observeLiveData() {

        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {
                countryName.text = it.countryName
                countryRegion.text = it.countryRegion
                countryCapital.text = it.countryCapital
                countryCurrency.text = it.countryCurrency
                countryLanguage.text = it.countryLanguage
                context.let {
                    countryImage.downoadFromUrl(country.flag, placeholderProgressBar(it!!))
                }

            }
        })

    }


}