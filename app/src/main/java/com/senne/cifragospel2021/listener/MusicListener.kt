package com.senne.cifragospel2021.listener

interface MusicListener {

    fun onClick( titulo: String, banda: String, foto: String )
    fun onClickAll( banda: String, foto: String )
    fun onClickMusics( banda: String, titulo: String )
}