package com.wahyukurnia.foodmarketkotlin.ui.auth.signup

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.github.dhaval2404.imagepicker.ImagePicker
import com.wahyukurnia.foodmarketkotlin.R
import com.wahyukurnia.foodmarketkotlin.ui.auth.AuthActivity
import kotlinx.android.synthetic.main.fragment_signup.*

class SignupFragment : Fragment() {

    var filePath:Uri? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDummy()
        initListiner()

        btnContinue.setOnClickListener {
            Navigation.findNavController(it)
                    .navigate(R.id.action_signup_address,null)

            (activity as AuthActivity).toolBarSignUpAddress()
        }
    }

    private fun initListiner() {
        ivProfile.setOnClickListener{
            ImagePicker.with(this)
                    .cameraOnly()
                    .start()
        }
    }

    private fun initDummy(){
        etFullName.setText("Wahyu Kurnia")
        etEmail.setText("wahyukurnia321123@gmail.com")
        etPassword.setText("wahyukurnia")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            filePath = data?.data
            Glide.with(this)
                    .load(filePath)
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivProfile)
        }else if(resultCode == ImagePicker.RESULT_ERROR){
            Toast.makeText(context,ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context,"Task Cancelled",Toast.LENGTH_SHORT).show()
        }
    }
}