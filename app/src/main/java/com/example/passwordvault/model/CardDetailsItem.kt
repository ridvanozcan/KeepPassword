package com.example.passwordvault.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by RIDVAN ÖZCAN on 27,DEC,2021
 */
@Entity(tableName = "CardDetailsTable")
data class CardDetailsItem(var cardHolder : String , var cardIssuer :String, @PrimaryKey var cardNumber :String, var cardExpiryMonth : String, var cardExpiryYear : String, var cardCvv : String) {

}