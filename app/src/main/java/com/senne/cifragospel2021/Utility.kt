package com.senne.cifragospel2021

import android.util.TypedValue
import android.widget.TextView

class Utility {

    fun tamamhoTitle(modelTitle: Int, itemViewTitle: TextView) {
         if(modelTitle > 42) {itemViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 9f)}
        else if(modelTitle> 39) {itemViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)}
        else if(modelTitle > 35) {itemViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11f)}
        else if(modelTitle> 30) {itemViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)}
        else if(modelTitle > 24) {itemViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)}
        else if(modelTitle > 19) {itemViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)}
    }

    fun tamanhoBand(modelBanda: Int, itemViewBanda: TextView) {
        if(modelBanda > 42) {itemViewBanda.setTextSize(TypedValue.COMPLEX_UNIT_SP, 9f)}
        else if(modelBanda > 39) {itemViewBanda.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)}
        else if(modelBanda > 35) {itemViewBanda.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11f)}
        else if(modelBanda> 30) {itemViewBanda.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)}
        else if(modelBanda > 24) {itemViewBanda.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)}
        else if(modelBanda > 19) {itemViewBanda.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)}
    }
}