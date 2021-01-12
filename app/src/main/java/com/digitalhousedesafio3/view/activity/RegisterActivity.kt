package com.digitalhousedesafio3.view.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import com.digitalhousedesafio3.R
import com.digitalhousedesafio3.databinding.ActivityRegisterBinding
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : BaseActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservables(binding)
    }

    private fun setupObservables(binding: ActivityRegisterBinding) = with(binding) {
        btRegister.setOnClickListener {
            setNameError(tilName)
            setEmailError(tilEmail)
            setPasswordError(tilPassword)

            if (!tilName.isErrorEnabled &&
                !tilEmail.isErrorEnabled &&
                !tilPassword.isErrorEnabled
            ) {
                val intent = Intent(this@RegisterActivity, HomeActivity::class.java)
                startActivity(intent)
            }
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

    private fun setNameError(textInputLayout: TextInputLayout) {
        if (isEmpty(textInputLayout)) {
            textInputLayout.error = getString(R.string.field_must_not_be_empty)
        } else {
            textInputLayout.isErrorEnabled = false
        }
    }

    private fun setEmailError(textInputLayout: TextInputLayout) {
        val email = textInputLayout.editText?.text.toString()
        if (!isEmpty(textInputLayout)) {
            if (!isValidEmail(email)) {
                textInputLayout.error = getString(R.string.insert_valid_email)
            } else {
                textInputLayout.isErrorEnabled = false
            }
        } else {
            textInputLayout.error = getString(R.string.field_must_not_be_empty)
        }
    }

    private fun setPasswordError(textInputLayout: TextInputLayout) {
        val password = textInputLayout.editText?.text.toString()
        when {
            isEmpty(textInputLayout) -> {
                textInputLayout.error = getString(R.string.field_must_not_be_empty)
            }
            !isValidPassword(password) -> {
                textInputLayout.error = getString(R.string.password_invalid)
            }
            else -> {
                textInputLayout.isErrorEnabled = false
            }
        }
    }

    private fun setRepeatPasswordError(
        password: TextInputLayout,
        repeatPassword: TextInputLayout
    ) {
        when {
            isEmpty(repeatPassword) -> {
                repeatPassword.error = getString(R.string.field_must_not_be_empty)
            }
            password != repeatPassword -> {
                repeatPassword.error = getString(R.string.password_not_a_match)
            }
            else -> {
                repeatPassword.isErrorEnabled = false
            }
        }
    }

}