package me.asiimwedismas.startelecom.feature.accessories

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import me.asiimwedismas.startelecom.core.model.Accessory
import me.asiimwedismas.startelecom.feature.accessories.databinding.ActivityAccessoryListBinding

@AndroidEntryPoint
class AccessoryListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccessoryListBinding
    private lateinit var accessoryAdapter: AccessoryAdapter

    private val viewModel: AccessoryListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityAccessoryListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        accessoryAdapter = AccessoryAdapter { accessory ->
            viewModel.onAccessoryClicked(accessory)
        }

        with(binding.recycler) {
            layoutManager = LinearLayoutManager(this@AccessoryListActivity)
            setHasFixedSize(true)
            adapter = accessoryAdapter
        }
        setSwipeToDeleteAccessory()

        viewModel.accessories.observe(this, accessoryAdapter::submitList)
        viewModel.showNewAccessoryDialog.observe(this) { shouldShowDialog ->
            if (shouldShowDialog)
                NewAccessoryDialog().show(supportFragmentManager, NewAccessoryDialog.TAG)
        }

        binding.fab.setOnClickListener {
            viewModel.showAddAccessoryDialog()
        }
    }

    private fun setSwipeToDeleteAccessory() {
        ItemTouchHelper(
            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean = false

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val swipedAccessory = accessoryAdapter.currentList[viewHolder.adapterPosition]
                    deleteConfirmationDialog(swipedAccessory)
                }
            }
        ).attachToRecyclerView(binding.recycler)
    }

    private fun deleteConfirmationDialog(
        swipedAccessory: Accessory,
    ) {
        MaterialAlertDialogBuilder(this@AccessoryListActivity)
            .setTitle("Delete accessory")
            .setMessage(
                """
                   You are about to delete:
                   ${swipedAccessory.name}
               """.trimIndent()
            )
            .setPositiveButton("Delete") { dialog: DialogInterface, _: Int ->
                viewModel.deleteAccessory(swipedAccessory)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog: DialogInterface, _: Int ->
                accessoryAdapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            .create()
            .show()
    }
}