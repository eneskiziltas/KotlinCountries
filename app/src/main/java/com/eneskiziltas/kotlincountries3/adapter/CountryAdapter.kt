package com.eneskiziltas.kotlincountries3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.eneskiziltas.kotlincountries3.R
import com.eneskiziltas.kotlincountries3.databinding.ItemCountryBinding
import com.eneskiziltas.kotlincountries3.model.Country
import com.eneskiziltas.kotlincountries3.util.downoadFromUrl
import com.eneskiziltas.kotlincountries3.util.placeholderProgressBar
import com.eneskiziltas.kotlincountries3.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener {


    class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.item_country,parent,false)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater,R.layout.item_country,parent,false)

        return CountryViewHolder(view)

    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {


        holder.view.country = countryList[position]
        holder.view.listener = this
        /*
        holder.view.name.text = countryList[position].countryName
        holder.view.region.text = countryList[position].countryRegion

        holder.view.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryUuid = countryList[position].uuid)

            Navigation.findNavController(it).navigate(action)
        }

        holder.view.imageView.downoadFromUrl(countryList[position].flag, placeholderProgressBar(holder.view.context))
        */
    }



    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountryList(newCountryList: List<Country>) {

        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()

    }

    override fun onCountryClicked(v: View) {
        val uuid = v.countryUuidText.text.toString().toInt()
        val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)

        Navigation.findNavController(v).navigate(action)
    }

}