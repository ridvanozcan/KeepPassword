package com.example.passwordvault.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.passwordvault.model.BankDetailsItem
import com.example.passwordvault.model.CardDetailsItem

/**
 * Created by RIDVAN ÖZCAN on 27,DEC,2021
 */

@Dao
interface CardDao {

    @Insert
    fun insertCardDetails(cardDetails : CardDetailsItem)

    @Query("DELETE FROM CardDetailsTable WHERE cardNumber = :cardNumber")
    fun deleteCardDetails(cardNumber : String)

    @Query("SELECT * FROM CardDetailsTable")
    fun getAllCardDetails() : LiveData<List<CardDetailsItem>>

}