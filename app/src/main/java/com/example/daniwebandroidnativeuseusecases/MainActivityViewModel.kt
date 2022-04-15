package com.example.daniwebandroidnativeuseusecases

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivityViewModel : ViewModel() {
    private val getNextFakeBusinessDataUseCase = GetNextFakeBusinessDataUseCase()

    //Private mutable flow
    private val _stateFlow = MutableStateFlow(
        getUiState()
    )

    //Exposes mutable flow as immutable flow
    val stateFlow: StateFlow<MainActivityUiState> = _stateFlow

    //MainActivity will call this function on button click
    fun loadNext(){
        _stateFlow.value = getUiState()
    }

    private fun getUiState(): MainActivityUiState {
        //val next = getNextFakeBusinessDataUseCase.getNextFakeBusinessData()
        val next = getNextFakeBusinessDataUseCase()
        return MainActivityUiState(
            item1 = next.item1,
            item2 = next.item2,
            item3 = next.item3
        )
    }

}

/*
class MainActivityViewModel : ViewModel() {
    //Private mutable flow
    private val _stateFlow = MutableStateFlow(
        getUiState()
    )

    //Exposes mutable flow as immutable flow
    val stateFlow: StateFlow<MainActivityUiState> = _stateFlow

    //MainActivity will call this function on button click
    fun loadNext(){
        _stateFlow.value = getUiState()
    }

    //Convenient function to remove code duplication
    private fun getUiState() = MainActivityUiState(
        item1 = "${Random.nextInt()}",
        item2 = "${Random.nextInt()}",
        item3 = "${Random.nextInt()}"
    )

}*/
