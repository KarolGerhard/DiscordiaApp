package br.com.akgs.discordia.ui.expense


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.akgs.discordia.R
import br.com.akgs.discordia.databinding.FragmentAddExpenseBinding
import br.com.akgs.discordia.domain.entities.Expense
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AddExpenseFragment : Fragment() {

    private var _binding: FragmentAddExpenseBinding? = null
    private val binding: FragmentAddExpenseBinding get() = _binding!!
    private val viewModel by sharedViewModel<AddExpenseViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddExpenseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val botaoAdicionar = binding.btnAdicionar

        botaoAdicionar.setOnClickListener { view ->
            val nomeItem = binding.edtNomeItem.text.toString()
            val valor = binding.edtValor.text.toString()
            val formaPagamento = binding.edtFormaPagamento.text.toString()
            val pessoaPagante = binding.edtPessoaPagante.text.toString()

            val addExpense = viewModel.addExpense(
                expense = Expense(
                    id = "",
                    userId = viewModel.getUser().id,
                    nomeItem,
                    valor.toDouble(),
                    formaPagamento,
                    pessoaPagante
                )
            )

            if (addExpense == "Success") {
                val snackbar = Snackbar.make(
                    view,
                    "Sucesso ao adicionar uma despesa",
                    Snackbar.LENGTH_SHORT
                )
                snackbar.setBackgroundTint(Color.BLUE)
                snackbar.show()
                binding.edtNomeItem.setText("")
                binding.edtValor.setText("")
                binding.edtFormaPagamento.setText("")
                binding.edtPessoaPagante.setText("")

                findNavController().navigate(R.id.action_addExpenseFragment_to_homeFragment)
            } else {
                val snackbar = Snackbar.make(
                    view,
                    "Erro ao adicionar despesa",
                    Snackbar.LENGTH_SHORT
                )
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}