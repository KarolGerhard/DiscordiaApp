package com.akgs.sharedtrip.model

class Expense
    (
    var id: String,
    var itemName: String? = "",
    var value: Double? = 0.0,
    var formaPagamento: String? = "",
    var pessoaPagante: String? = ""
) {
}