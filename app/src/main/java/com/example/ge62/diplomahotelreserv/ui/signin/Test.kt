//package com.example.ge62.diplomahotelreserv.ui.signin
//
//import android.content.Intent
//import android.os.Bundle
//import android.support.design.widget.TextInputLayout
//import android.view.View
//import android.widget.Button
//import com.example.ge62.diplomahotelreserv.BaseActivity
//import com.example.ge62.diplomahotelreserv.R
//import com.example.ge62.diplomahotelreserv.ui.RegisterActivity
//import com.example.ge62.diplomahotelreserv.ui.UserEnteredActivity
//import kotlinx.android.synthetic.main.activity_auth.*
//import java.util.regex.Matcher
//import java.util.regex.Pattern
//
//
//class MainActivity : BaseActivity() {
//    override fun getLayoutRes()=R.layout.activity_auth
//
//    override fun initViews() {
//     registerBtn.setOnClickListener(this)
//        loginBtn.setOnClickListener(this)
//    }
//
//    override fun release() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    companion object {
//
//        private val EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"
//    }
//
//    private val pattern = Pattern.compile(EMAIL_PATTERN)
//    private var matcher: Matcher? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_auth)
//
//
//        val emailWrapper = findViewById(R.id.emailWrapper) as TextInputLayout
//        val passwordWrapper = findViewById(R.id.passwordWrapper) as TextInputLayout
//
//        registerBtn.setOnClickListener {
//            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
//            startActivity(intent)
//        }
//
//        loginBtn.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(view: View) {
//                validateAllFields()
//
//
//            }
//
//            fun validateAllFields() {
//                val email = emailWrapper.editText!!.text.toString()
//                val pass = passwordWrapper.editText!!.text.toString()
//
//                if (!validateEmail(email) && !validatePassword(pass)) {
//                    emailWrapper.error = "invalid email address!"
//                    passwordWrapper.error = "password will consist from 6 symbols!"
//                } else if (!validateEmail(email) && validatePassword(pass)) {
//                    emailWrapper.error = "invalid email address!"
//                    passwordWrapper.isErrorEnabled = false
//                } else if (validateEmail(email) && !validatePassword(pass)) {
//                    emailWrapper.isErrorEnabled = false
//                    passwordWrapper.error = "password will consist from 6 symbols!"
//                } else {
//                    //signIn(emailWrapper.getEditText().getText().toString(),passwordWrapper.getEditText().getText().toString(),grant_type);
//                    doLogin()
//                }
//            }
//
//        })
//
//    }
//
//
//    fun validateEmail(email: String): Boolean {
//        matcher = pattern.matcher(email)
//        return matcher!!.matches()
//    }
//
//    fun validatePassword(password: String): Boolean {
//        return password.length > 6
//    }
//
//    fun doLogin() {
//        val intent = Intent(this@MainActivity, UserEnteredActivity::class.java)
//        startActivity(intent)
//    }
//
//
//
//
//}