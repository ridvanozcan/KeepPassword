package com.example.passwordvault.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by RIDVAN ÖZCAN on 27,DEC,2021
 */
@Entity(tableName = "LoginDetailsTable")
data class LoginDetailsItem(@PrimaryKey var Id : String, var loginName:String, var loginEmail : String, var loginPassword : String, var loginWebsite : String, var loginNotes : String, var loginCategory : String) {

}