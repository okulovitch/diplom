package com.example.ge62.diplomahotelreserv

import android.support.v7.widget.Toolbar

interface ToolbarListener {
    fun initToolbar(toolbar: Toolbar, title: String, showBack: Boolean = false)
}