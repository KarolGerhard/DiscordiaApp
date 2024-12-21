package br.com.akgs.discordia.domain.entities

class Expense
    (
    var id: String,
    var userId: String? = "",
    var itemName: String? = "",
    var value: Double? = 0.0,
    var paymentMethod: String? = "",
    var peoplePaid: String? = ""
)