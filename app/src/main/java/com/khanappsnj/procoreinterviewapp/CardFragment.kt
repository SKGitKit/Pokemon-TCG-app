package com.khanappsnj.procoreinterviewapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isEmpty
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.khanappsnj.procoreinterviewapp.databinding.CardFragmentBinding
import com.khanappsnj.procoreinterviewapp.Constants.NAME
import com.khanappsnj.procoreinterviewapp.Constants.TYPE
import com.khanappsnj.procoreinterviewapp.Constants.HP


class CardFragment : Fragment() {

    private lateinit var cardAdapter: CardAdapter
    private val cardViewModel: CardViewModel by viewModels()
    private var _binding: CardFragmentBinding? = null
    val binding: CardFragmentBinding
        get() = checkNotNull(_binding) {
            "_binding needs to be initialized"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CardFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        cardViewModel.cards.observe(requireActivity()) { card ->
            binding.cardRecyclerView.apply {
                Log.d("Card","This is the types: ${card.data.first().attacks.first().damage == ""}")
                layoutManager = GridLayoutManager(requireContext(), 4)
                adapter = CardAdapter(card?.data.orEmpty()) { card ->
                    findNavController().navigate(
                        CardFragmentDirections.showCardDetail(
                            cardImage = card.images.large,
                            cardName = card.name
                        )
                    )
                }.also { cardAdapter = it }
            }
            binding.apply {
                typeSort.apply {
                    isEnabled = true
                    setOnClickListener {
                        cardAdapter.sortData(TYPE)
                        cardViewModel.updateCards { oldCards ->
                            oldCards?.copy(data = oldCards.data.sortedBy { it.types.first() })
                        }
                    }
                }
                nameSort.apply {
                    isEnabled = true
                    setOnClickListener {
                        cardAdapter.sortData(NAME)
                        cardViewModel.updateCards { oldCards ->
                            oldCards?.copy(data = oldCards.data.sortedBy { it.name})
                        }
                    }
                    hpSort.apply {
                        isEnabled = true
                        setOnClickListener {
                            cardAdapter.sortData(HP)
                            cardViewModel.updateCards { oldCards ->
                                oldCards?.copy(data = oldCards.data.sortedBy { it.hp })
                            }
                        }
                    }
                }

                cardViewModel.finishedLoading.observe(requireActivity()) { loaded ->
                    if (loaded) {
                        binding.loadingCards.visibility = View.GONE
                    }
                }

            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}