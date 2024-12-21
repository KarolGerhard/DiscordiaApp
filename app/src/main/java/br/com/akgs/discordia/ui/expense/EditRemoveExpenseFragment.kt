package br.com.akgs.discordia.ui.expense

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.akgs.discordia.R
import br.com.akgs.discordia.databinding.FragmentEditRemoveExpenseBinding
import br.com.akgs.discordia.domain.entities.Expense
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class EditRemoveExpenseFragment : Fragment() {

    private var _binding: FragmentEditRemoveExpenseBinding? = null
    private val binding: FragmentEditRemoveExpenseBinding get() = _binding!!

    private val viewModel by sharedViewModel<EditRemoveExpenseViewModel>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditRemoveExpenseBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString("id")
        val userId = arguments?.getString("userId")
        val itemName = arguments?.getString("itemName")
        val value = arguments?.getDouble("value")
        val paymentMethod = arguments?.getString("paymentMethod")
        val peoplePaid = arguments?.getString("peoplePaid")


        binding.edtNomeItem.setText(itemName)
        binding.edtValor.setText(value.toString())
        binding.edtFormaPagamento.setText(paymentMethod)
        binding.edtPessoaPagante.setText(peoplePaid)


        binding.btnAtualiza.setOnClickListener {
            val nomeItem = binding.edtNomeItem.text.toString()
            val valor = binding.edtValor.text.toString().toDoubleOrNull() ?: 0.0
            val formaPagamento = binding.edtFormaPagamento.text.toString()
            val pessoaPagante = binding.edtPessoaPagante.text.toString()

            val updatedExpense = viewModel.editExpense(
                expense = Expense(
                    id ?: "", userId, nomeItem, valor, formaPagamento, pessoaPagante
                )
            )

            if (updatedExpense == "Success") {
                val snackbar = Snackbar.make(
                    view,
                    "Sucesso ao alterar a despesa",
                    Snackbar.LENGTH_SHORT
                )
                snackbar.setBackgroundTint(Color.BLUE)
                snackbar.show()
                binding.edtNomeItem.setText("")
                binding.edtValor.setText("")
                binding.edtFormaPagamento.setText("")
                binding.edtPessoaPagante.setText("")

                findNavController().navigate(R.id.action_editRemoveExpenseFragment_to_homeFragment)
            } else {
                val snackbar = Snackbar.make(
                    view,
                    "Erro ao alterar despesa",
                    Snackbar.LENGTH_SHORT
                )
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }
        }

        binding.btnRemove.setOnClickListener {
            val deleteExpense = viewModel.removeExpense(expense = Expense(id = id!!))

            if (deleteExpense == "Success") {
                val snackbar = Snackbar.make(
                    view,
                    "Sucesso ao apagar a despesa",
                    Snackbar.LENGTH_SHORT
                )
                snackbar.setBackgroundTint(Color.BLUE)
                snackbar.show()
                binding.edtNomeItem.setText("")
                binding.edtValor.setText("")
                binding.edtFormaPagamento.setText("")
                binding.edtPessoaPagante.setText("")

                findNavController().navigate(R.id.action_editRemoveExpenseFragment_to_homeFragment)
            } else {
                val snackbar = Snackbar.make(
                    view,
                    "Erro ao apagar despesa",
                    Snackbar.LENGTH_SHORT
                )
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }
        }
        binding.btnVoltar.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}