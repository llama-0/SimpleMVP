package com.llama.simplemvp.presenters

import android.content.res.Resources
import com.llama.simplemvp.models.Model
import com.llama.simplemvp.R
import com.llama.simplemvp.contracts.EnterNameContract

class EnterNamePresenter(
    private val view: EnterNameContract.View,
    private val model: Model,
    private val resources: Resources
) : EnterNameContract.Presenter {

    private fun saveName(name: String) =
        model.setName(name)

    override fun initView() =
        view.showName(model.getName())

    override fun onShowResponseButtonClicked() {
        if (model.getName().isEmpty()) {
            view.showMessage(resources.getString(R.string.default_message))
        } else {
            view.showResponseActivity()
        }
    }

    override fun onNameChanged(name: String) {
        if (name != model.getName()) {
            saveName(name)
        }
    }

    override fun onRadioButtonChecked(color: Int) {
        model.setColor(color)
    }

    override fun putRadioGroupResult(): Int =
        model.getColor()

}