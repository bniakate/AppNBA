package com.example.esiea3a.affichage.list

sealed class LegendModel

data class LegendSuccess(val legendList : List<Legend>) : LegendModel()
object LegendLoader : LegendModel()
object LegendError : LegendModel()