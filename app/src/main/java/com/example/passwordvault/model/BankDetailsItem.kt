package com.example.passwordvault.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by RIDVAN ÖZCAN on 27,DEC,2021
 */
@Entity(tableName = "BankDetailsTable")
data class BankDetailsItem(var bankName:String, @PrimaryKey var bankAccNumber : Long, var bankIFSC : String, var bankAddress : String) {

}