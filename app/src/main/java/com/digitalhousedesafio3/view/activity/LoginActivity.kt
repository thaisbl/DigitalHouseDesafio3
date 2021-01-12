package com.digitalhousedesafio3.view.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import com.digitalhousedesafio3.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservables(binding)
    }


    private fun setupObservables(binding: ActivityLoginBinding) = with(binding) {
        btLogIn.setOnClickListener {
            setEmailError(tilEmail)
            setPasswordError(tilPassword)

            if (!tilEmail.isErrorEnabled && !tilPassword.isErrorEnabled) {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)

            }
        }

        btCreateAccount.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }


    private fun isEmpty(textInputLayout: TextInputLayout): Boolean {
        return textInputLayout.editText?.text.toString().isBlank()
    }

    private fun isValidPassword(password: String?): Boolean {
        password?.let {
            val passwordPattern =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&*()-+=])(?=\\S+$).{8,}$"
            val passwordMatcher = Regex(passwordPattern)
            return passwordMatcher.find(password) != null
        } ?: return false
    }

    private fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    private fun setEmailError(textInputLayout: TextInputLayout) {
        val email = textInputLayout.editText?.text.toString()
        if (isEmpty(textInputLayout)) {
            textInputLayout.error = "Field must not be empty"
        } else if (!isValidEmail(email)) {
            textInputLayout.error = "Insert a valid email"
        } else {
            textInputLayout.isErrorEnabled = false
        }
    }

    private fun setPasswordError(textInputLayout: TextInputLayout) {
        val password = textInputLayout.editText?.text.toString()
        if (isEmpty(textInputLayout)) {
            textInputLayout.error = "Field must not be empty"
        } else if (!isValidPassword(password)) {
            textInputLayout.error = "Password must contain at least:\\n- 8 Characters\n" +
                    "\\n- 1 Uppercase & 1 Lowercase letter\\n- 1 Number \\n- 1 Special Character"
        } else {
            textInputLayout.isErrorEnabled = false
        }
    }
}