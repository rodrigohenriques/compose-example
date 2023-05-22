package com.rodrigohenriques.compose.example

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.rodrigohenriques.compose.example.databinding.FragmentLegacyViewsBinding
import com.rodrigohenriques.compose.example.databinding.HolderContactItemBinding
import com.rodrigohenriques.compose.example.ui.model.Contact
import com.rodrigohenriques.compose.example.ui.model.contacts

class LegacyViewsFragment : Fragment(R.layout.fragment_legacy_views) {

  private val binding by lazy { FragmentLegacyViewsBinding.bind(requireView()) }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.recyclerView.adapter = ContactsAdapter(contacts)
    binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
  }
}

class ContactsAdapter(
  contacts: List<Contact>,
) : ListAdapter<Contact, ContactsAdapter.ContactsViewHolder>(DIFF_CALLBACK) {

  init {
    submitList(contacts)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
    return ContactsViewHolder(
      HolderContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
  }

  override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) =
    holder.bind(getItem(position))

  class ContactsViewHolder(private val binding: HolderContactItemBinding) : ViewHolder(binding.root) {
    fun bind(contact: Contact) {
      binding.contactName.text = contact.name
      binding.contactNumber.text = contact.phone
    }
  }

  companion object {
    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Contact>() {
      override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.id == newItem.id
      }

      override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
      }
    }
  }
}