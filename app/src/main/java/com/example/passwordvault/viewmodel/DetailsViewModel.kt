package com.example.passwordvault.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.passwordvault.model.BankDetailsItem
import com.example.passwordvault.model.CardDetailsItem
import com.example.passwordvault.model.LoginDetailsItem
import com.example.passwordvault.repository.Repository
import kotlin.math.log

/**
 * Created by RIDVAN ÖZCAN on 27,DEC,2021
 */

class DetailsViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel() {

    private var bankDetailsList : LiveData<List<BankDetailsItem>>
    private var cardDetailsList : LiveData<List<CardDetailsItem>>
    private var loginDetaisList : LiveData<List<LoginDetailsItem>>


    init {
        bankDetailsList = repository.getAllBankDetails()
        cardDetailsList = repository.getAllCardDetails()
        loginDetaisList = repository.getAllLoginDetails()
    }


    fun getAllBankDetails() : LiveData<List<BankDetailsItem>>{
        return bankDetailsList
    }

    fun insertBankDetails(bankDetailsItem: BankDetailsItem){
        repository.insertBankDetails(bankDetailsItem)
    }

    fun deleteBankDetails(accNumber: Long){
        repository.deleteBankDetails(accNumber)
    }

    fun insertCardDetails(cardDetailsItem: CardDetailsItem){
        repository.insertCardDetails(cardDetailsItem)
    }

    fun deleteCardDetails(cardNumber: String){
        repository.deleteCardDetails(cardNumber)
    }

    fun getAllCardDetails() : LiveData<List<CardDetailsItem>>{
        return cardDetailsList
    }

    fun insertLoginDetails(loginDetailsItem: LoginDetailsItem){
        repository.insertLoginDetails(loginDetailsItem)
    }

    fun deleteLoginDetails(id: String){
        repository.deleteLoginDetails(id)
    }


    fun getAllLoginDetails() : LiveData<List<LoginDetailsItem>>{
        return loginDetaisList
    }
    fun getCategoryLoginDetails(category : String) : LiveData<List<LoginDetailsItem>>{
        return repository.getCategoryLoginDetails(category)
    }


}