package vakili.mahda.mehregan.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isEmpty
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import vakili.mahda.mehregan.R
import vakili.mahda.mehregan.databinding.FragmentProductBinding


class ProductFragment : Fragment() {
    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        if (binding.recyclerViewProducts.isEmpty()) {
            binding.tvMainAccountingNoData.isVisible = true
        }

          binding.floatingActionButton.setOnClickListener {
    Navigation.findNavController(view).navigate(R.id.action_productFragment_to_addProductFragment)
}
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}