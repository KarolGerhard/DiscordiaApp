package br.com.akgs.discordia.ui.expense.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.akgs.discordia.R
import br.com.akgs.discordia.domain.entities.Expense

class ExpenseAdapter(
    private val expenses: List<Expense>,
    private val onItemClick: (Expense) -> Unit
) : RecyclerView.Adapter<ExpenseAdapter.DespesasHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DespesasHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcv_despesas, parent, false)
        return DespesasHolder(view)
    }

    override fun onBindViewHolder(holder: DespesasHolder, position: Int) {
        val despesa = expenses[position]
        holder.txtNomeItem.text = despesa.itemName
        holder.txtValor.text = despesa.value.toString()
        holder.txtFormaPagamento.text = despesa.paymentMethod
        holder.txtPessoaPagante.text = despesa.peoplePaid

        holder.itemView.setOnClickListener {
            onItemClick(despesa)
        }
    }

    override fun getItemCount(): Int = expenses.size

     class DespesasHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var txtNomeItem: TextView = itemView.findViewById(R.id.txtName)
        var txtValor: TextView = itemView.findViewById(R.id.txtValor)
        var txtFormaPagamento: TextView = itemView.findViewById(R.id.txtPagamento)
        var txtPessoaPagante: TextView = itemView.findViewById(R.id.txtPessoa)
    }
}