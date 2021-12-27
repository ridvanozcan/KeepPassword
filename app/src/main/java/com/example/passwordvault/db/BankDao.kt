package com.example.passwordvault.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.passwordvault.model.BankDetailsItem

/**
 * Created by RIDVAN ÖZCAN on 27,DEC,2021
 */

@Dao
interface BankDao {

    @Insert
    fun insertBankDetails(bankDetails : BankDetailsItem)

    @Query("DELETE FROM BankDetailsTable WHERE bankAccNumber = :accNumber")
    fun deleteBankDetails(accNumber : Long)

    @Query("SELECT * FROM BankDetailsTable")
    fun getAllBankDetails() : LiveData<List<BankDetailsItem>>

}