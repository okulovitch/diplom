package com.example.ge62.diplomahotelreserv.ui.signin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.ge62.diplomahotelreserv.BaseActivity
import com.example.ge62.diplomahotelreserv.R
import com.example.ge62.diplomahotelreserv.ui.UserEnteredActivity
import com.example.ge62.diplomahotelreserv.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_auth.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignInActivity: BaseActivity(),SignInContract.View, View.OnClickListener {


    private var presenter: SignInContract.Presenter? = null

    companion object {
        fun prepareIntent(context: Context) = Intent(context, SignInActivity::class.java)



    }


    private val USERNAME_PATTERN = "^[a-zA-Z\\s]+"
    private val pattern = Pattern.compile(USERNAME_PATTERN)
    private var matcher: Matcher? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = SignInPresenter()
        presenter?.onAttachView(this)
    }
    override fun openSignUpScreen() {
        openRegisterScreen()
    }

    override fun openMainScreen() {
       startLoginUser()
    }

    override fun getLayoutRes()= R.layout.activity_auth

    override fun initViews() {
       loginBtn.setOnClickListener(this)
        registerBtn.setOnClickListener(this)
    }

    fun validateEmail(email: String): Boolean {
        matcher = pattern.matcher(email)
        return matcher!!.matches()
    }

    fun validatePassword(password: String): Boolean {
        return password.length > 6
    }

    override fun badLoginPssword() {

    }

    fun openRegisterScreen(){
        val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
    }
    fun startLoginUser(){
        val intent = Intent(this,UserEnteredActivity::class.java)
        startActivity(intent)
    }
    fun validateAllFields() {
        val email = emailWrapper.editText!!.text.toString()
        val pass = passwordWrapper.editText!!.text.toString()

        if (!validateEmail(email) && !validatePassword(pass)) {
            emailWrapper.error = "invalid username!"
            passwordWrapper.error = "password will consist from 6 symbols!"
        } else if (!validateEmail(email) && validatePassword(pass)) {
            emailWrapper.error = "invalid username!"
            passwordWrapper.isErrorEnabled = false
        } else if (validateEmail(email) && !validatePassword(pass)) {
            emailWrapper.isErrorEnabled = false
            passwordWrapper.error = "password will consist from 6 symbols!"
        } else {
            //signIn(emailWrapper.getEditText().getText().toString(),passwordWrapper.getEditText().getText().toString(),grant_type);

        presenter?.onLoginRequest(etEmail.text.toString(), etPassword.text.toString())

          //   startLoginUser()


        }
    }

    override fun release() {

    }
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.loginBtn -> {validateAllFields()}
            R.id.registerBtn -> {presenter?.onSignUpClick()}

            }

        }

}