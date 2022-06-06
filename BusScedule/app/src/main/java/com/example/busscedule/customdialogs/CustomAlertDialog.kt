package com.example.busscedule.customdialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.busscedule.R

class CustomAlertDialog (
    val icon:Int = R.drawable.ic_baseline_info_24,
    val title: String,
    val body: String,
    val positiveButtonText: String,
    val negativeButtonText: String,
    val positiveButtonClickCallback: () -> Unit
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity()).apply {
            setTitle(title)
            setMessage(body)
            setIcon(icon)
            setPositiveButton(positiveButtonText) { dialogInterface, i ->
                positiveButtonClickCallback()
            }
            setNegativeButton(negativeButtonText, null)
        }
        return builder.create()
    }
}