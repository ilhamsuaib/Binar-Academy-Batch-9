package id.ilhamsuaib.constraintlayout.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ilhamsuaib.constraintlayout.R
import id.ilhamsuaib.constraintlayout.data.PreferenceHelper
import id.ilhamsuaib.constraintlayout.data.PreferenceKey
import kotlinx.android.synthetic.main.fragment_profile.view.*
import id.ilhamsuaib.constraintlayout.ui.activity.LoginActivity

/**
 * Created by @ilhamsuaib on 11/10/18.
 * github.com/ilhamsuaib
 */

class ProfileFragment : Fragment() {

    private lateinit var pref: PreferenceHelper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = PreferenceHelper(view.context)

        val username = pref.getString(PreferenceKey.USERNAME)
        view.tvUsername.text = "Hello, $username"

        view.btnLogOut.setOnClickListener {
            logOut()
        }
    }

    private fun logOut() {
        pref.logOut()
        val goToLogin = Intent(context, LoginActivity::class.java)
        startActivity(goToLogin)
        activity?.finish()
    }
}