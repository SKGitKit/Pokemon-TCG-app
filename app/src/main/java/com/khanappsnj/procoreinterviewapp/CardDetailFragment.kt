package com.khanappsnj.procoreinterviewapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.khanappsnj.procoreinterviewapp.databinding.CardDetailBinding

class CardDetailFragment : Fragment() {
    private val args:CardDetailFragmentArgs by navArgs()
    private var _binding: CardDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CardDetailBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            Glide.with(binding.root).load(args.cardImage).into(cardImageLarge)
            cardName.text = args.cardName
        }

    }
}