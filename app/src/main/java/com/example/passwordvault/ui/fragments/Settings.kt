package com.example.passwordvault.ui.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.passwordvault.databinding.SettingsBinding
import com.example.passwordvault.ui.activities.Login
import java.lang.StringBuilder

/**
 * Created by RIDVAN ÖZCAN on 27,DEC,2021
 */
class Settings : Fragment() {

    private lateinit var binding: SettingsBinding
    private lateinit var preference : SharedPreferences
    private  var masterPIN : String? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SettingsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preference = requireActivity().getSharedPreferences("PasswordPreferences", Context.MODE_PRIVATE)

        if(preference.contains("PIN"))
            masterPIN = preference.getString("PIN","No Pin")

        binding.changeMasterPIN.setOnClickListener {
            var oldPin = binding.oldPIN.text.toString().trim()
            var newPIN = binding.newPIN.text.toString().trim()
            var confirmedPIN = binding.confirmNewPIN.text.toString().trim()
            if(masterPIN != "No Pin" || masterPIN != null){
                if(oldPin != masterPIN)
                    Toast.makeText(requireContext(),"Eski Şifre Yanlış!",Toast.LENGTH_SHORT).show()
                else if(newPIN != confirmedPIN)
                    Toast.makeText(requireContext(),"Şifreler Eşleşmiyor!",Toast.LENGTH_SHORT).show()
                else{
                    var editor = preference.edit()
                    editor.putString("PIN",newPIN)
                    editor.commit()
                    Toast.makeText(requireContext(),"Şifre Değiştirildi!",Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}