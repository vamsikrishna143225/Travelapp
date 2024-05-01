package com.example.packyourbags

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    lateinit var  drawer: DrawerLayout
    lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        var actionBarDrawerToggle = ActionBarDrawerToggle(this,drawer,toolbar,
            R.string.navigation_drawer_open,R.string.navigation_drawer_close)

        drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentOne()).commit()
            navigationView.setCheckedItem(R.id.nav_message)
        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.nav_message -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentOne())
                .commit()

            R.id.nav_chat -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentTwo())
                .commit()

            R.id.nav_profile -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentThree())
                .commit()

            R.id.nav_rate -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentFour())
                .commit()

            R.id.nav_up-> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentFive())
                .commit()

            R.id.nav_login-> supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentLogin())
                .commit()

            R.id.nav_logout -> {
                Toast.makeText(this, "Successfully Logged-out", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragmentLogin()).commit()
            }

            R.id.nav_share -> Toast.makeText(this, "Message shared", Toast.LENGTH_SHORT).show()
            R.id.nav_send -> Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show()

        }
        drawer.closeDrawer(GravityCompat.START)
        return true

    }
}