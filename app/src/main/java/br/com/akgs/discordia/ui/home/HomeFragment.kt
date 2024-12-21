package br.com.akgs.discordia.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.akgs.discordia.R
import br.com.akgs.discordia.databinding.FragmentHomeBinding
import br.com.akgs.discordia.ui.expense.adapter.ExpenseAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var despesasAdapter: ExpenseAdapter
    private val viewModel by sharedViewModel<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rcvDespesas
        recyclerView.layoutManager = LinearLayoutManager(context)

        val btnDivider = binding.btnDividir

        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            (recyclerView.layoutManager as LinearLayoutManager).orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)

        viewModel.expenses.observe(viewLifecycleOwner, Observer { expenses ->
            if (expenses.isNotEmpty()) {
                despesasAdapter = ExpenseAdapter(expenses) { expense ->
                    val bundle = bundleOf(
                        "id" to expense.id,
                        "userId" to expense.userId,
                        "itemName" to expense.itemName,
                        "value" to expense.value,
                        "methodPayment" to expense.paymentMethod,
                        "peoplePaid" to expense.peoplePaid
                    )
                    findNavController().navigate(
                        R.id.action_homeFragment_to_editRemoveExpenseFragment,
                        bundle
                    )
                }
                recyclerView.adapter = despesasAdapter
                despesasAdapter.notifyDataSetChanged()
            }
        })

        viewModel.loadUserExpenses()

        viewModel.totalExpenses.observe(viewLifecycleOwner, Observer { total ->
            binding.txtTotal.text = String.format("%.2f", total)
        })

        btnDivider.setOnClickListener {
            val qtdPersons = binding.edtPessoaPagante.text.toString().toInt()
            val totalExpenses = binding.txtTotal.text.toString().toDouble()
            val totalPerPerson = viewModel.divideExpense(qtdPersons, totalExpenses)
            binding.txtTotalDividido.text = String.format("%.2f", totalPerPerson)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
