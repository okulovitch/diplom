package com.example.ge62.diplomahotelreserv

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

abstract class BaseActivity : AppCompatActivity(), ToolbarListener {

    protected var toolbarView: Toolbar?= null
    private var titleView: TextView? = null

    protected var isShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())

        initViews()
    }

    override fun initToolbar(toolbar: Toolbar, title: String, showBack: Boolean) {
        this.toolbarView = toolbar
        titleView = toolbarView?.findViewById(R.id.toolbarTitle)
        setSupportActionBar(toolbar)
        setTitle(title)
        supportActionBar?.setDisplayHomeAsUpEnabled(showBack)
    }

    protected fun setTitle(newTitle: String) {
        toolbarView?.findViewById<TextView>(R.id.toolbarTitle)?.text = newTitle
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if(getMenuRes() != 0) {
            menu?.clear()
            menuInflater.inflate(getMenuRes(), menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == android.R.id.home) {
            onBackPressed()
            return true
        } else return super.onOptionsItemSelected(item)
    }




    override fun onResume() {
        super.onResume()

        isShown = true
    }

    override fun onPause() {
        super.onPause()

        isShown = false
    }

    override fun onDestroy() {
        release()
        super.onDestroy()
    }


    protected open fun getMenuRes() = 0

    protected abstract fun getLayoutRes() : Int
    protected abstract fun initViews()
    protected abstract fun release()

}