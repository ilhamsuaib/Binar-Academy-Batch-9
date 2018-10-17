package id.ilhamsuaib.constraintlayout.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import id.ilhamsuaib.constraintlayout.R
import id.ilhamsuaib.constraintlayout.ui.fragment.AcademyFragment
import id.ilhamsuaib.constraintlayout.ui.fragment.HelpFragment
import id.ilhamsuaib.constraintlayout.ui.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupView()
    }

    private fun setupView() {
        setupFragment(AcademyFragment(), getString(R.string.academy))

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_academy -> {
                    setupFragment(AcademyFragment(), getString(R.string.academy))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_help -> {
                    setupFragment(HelpFragment(), getString(R.string.help))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_profile -> {
                    setupFragment(ProfileFragment(), getString(R.string.profile))
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    private fun setupFragment(fragment: Fragment, title: String) {
        this.title = title
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_student, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.addNewStudent)
            startActivity(Intent(this, NewStudentActivity::class.java))
        return super.onOptionsItemSelected(item)
    }
}
