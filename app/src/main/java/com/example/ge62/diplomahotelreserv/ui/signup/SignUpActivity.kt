package com.example.ge62.diplomahotelreserv.ui.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.ge62.diplomahotelreserv.BaseActivity
import com.example.ge62.diplomahotelreserv.R
import com.example.ge62.diplomahotelreserv.ui.signin.SignInActivity
import kotlinx.android.synthetic.main.activity_register.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpActivity : BaseActivity(),SignUpContract.View, View.OnClickListener  {


    private var presenter: SignUpContract.Presenter? = null
    override fun getLayoutRes()= R.layout.activity_register

    private val USERNAME_PATTERN = "^[a-zA-Z\\s]+"
    private val EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"
    private val NAMES_PATTERN = "^[a-zA-Z\\s]+"
    private val PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})"
    private val PHONE_PATTERN = "^[+][0-9]{10,13}$"
    private var matcher: Matcher? = null
    private val pattern = Pattern.compile(USERNAME_PATTERN)
    private val patternEmail = Pattern.compile(EMAIL_PATTERN)
    private val patternName = Pattern.compile(NAMES_PATTERN)
    private val patternPassword = Pattern.compile(PASSWORD_PATTERN)
    private val patternPhone = Pattern.compile(PHONE_PATTERN)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SignUpPresenter()
        presenter?.onAttachView(this)
    }
        override fun initViews() {
        initToolbar(toolbar,"on login",true)
            onLoginBtn.setOnClickListener(this)
    }

    private fun isPasswordEqals(): Boolean {

        return if (PasswordWrapper.editText!!.text.toString() == PasswordCheckWrapper.getEditText()!!.getText().toString()) {
            true
        } else {
            false
        }
    }
    private fun isInputCorrect() {

        FirstNameWraper.setErrorEnabled(false)
        EmailWrapper.setErrorEnabled(false)
        PasswordWrapper.setErrorEnabled(false)
        PasswordCheckWrapper.setErrorEnabled(false)
        UserNameWrapper.setErrorEnabled(false)
        var isValid = true
        if (FirstNameWraper.getEditText()!!.getText().toString().isEmpty()) {
            FirstNameWraper.setError(resources.getString(R.string.notEmpty))
            isValid = false

        } else if (!validateFirstName(FirstNameWraper.getEditText()!!.getText().toString())) {
            FirstNameWraper.setError(resources.getString(R.string.firstName))
            isValid = false
        }

        if (UserNameWrapper.getEditText()!!.getText().toString().isEmpty()) {
            UserNameWrapper.setError(resources.getString(R.string.notEmpty))
            isValid = false

        } else if (!validateFirstName(UserNameWrapper.getEditText()!!.getText().toString())) {
            UserNameWrapper.setError(resources.getString(R.string.userName))
            isValid = false
        }


        if (EmailWrapper.getEditText()?.getText().toString().isEmpty()) {
            EmailWrapper.setError(resources.getString(R.string.notEmpty))
            isValid = false
        } else if (!validateEmail(EmailWrapper.getEditText()!!.getText().toString())) {
            EmailWrapper.setError(resources.getString(R.string.emailIncorect))
            isValid = false
        }
        if (PasswordWrapper.getEditText()?.getText().toString().isEmpty()) {
            PasswordWrapper.setError(resources.getString(R.string.notEmpty))
            isValid = false
        }
        if (PasswordCheckWrapper.getEditText()?.getText().toString().isEmpty()) {
            PasswordCheckWrapper.setError(resources.getString(R.string.notEmpty))
            isValid = false
        }
        if (!isPasswordEqals()) {
            PasswordWrapper.setError(resources.getString(R.string.notEquals))
            PasswordCheckWrapper.setError(resources.getString(R.string.notEquals))
            isValid = false
        }
        if (!validatePassword(PasswordWrapper.getEditText()!!.getText().toString())) {
            PasswordWrapper.setError(resources.getString(R.string.badPass))
            isValid = false
        }
        if (!validatePassword(PasswordCheckWrapper.getEditText()!!.getText().toString())) {
            PasswordCheckWrapper.setError(resources.getString(R.string.badPass))
            isValid = false
        }


        if (isValid == true) {
          presenter?.onRegisterRequest(etUserName.text.toString(),etPasswordRegister.text.toString(),EmailWrapper.getEditText()?.getText().toString(),etFirstName.text.toString())
        }

    }


    fun validatePhone(phone: String): Boolean {
        matcher = patternPhone.matcher(phone)
        return matcher!!.matches()
    }

    fun validateEmail(email: String): Boolean {
        matcher = patternEmail.matcher(email)
        return matcher!!.matches()
    }

    fun validatePassword(password: String): Boolean {
        return password.length > 6
        //matcher = patternPassword.matcher(password);
        // return matcher.matches();
    }

    fun validateFirstName(firstName: String): Boolean {
        matcher = patternName.matcher(firstName)
        return matcher!!.matches()
    }



    fun onLogin(){
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }

    override fun release() {

    }

    override fun openSignInScreen() {
        onLogin()
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.onLoginBtn ->{isInputCorrect()}
            }

        }
}