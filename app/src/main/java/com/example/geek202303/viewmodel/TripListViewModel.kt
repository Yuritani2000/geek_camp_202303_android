package com.example.geek202303.viewmodel

import androidx.lifecycle.ViewModel
import com.example.geek202303.model.TripRepository
import com.example.geek202303.view.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class TripListViewModel @Inject constructor() : ViewModel() {

    private val repository = TripRepository()

    /**
     * StateはStateFlowで保持
     */
    private val _state = MutableStateFlow(TripListState.initialState)
    val state = _state.asStateFlow()

    private fun currentState() = _state.value
    private fun updateState(newState: () -> TripListState) {
        _state.value = newState()
    }

    /**
     * Viewから送られるイベントを処理
     */
    fun onEvent(event: TripListEvent) {
        when(event) {
            OnClickTripEvent -> onClickTripEvent()
            UpdateListEvent -> updateListEvent()
        }
    }

    private fun onClickTripEvent(){
        val oldState = currentState()
    }

    private fun updateListEvent() {
        TripRepository.executorService.execute {
            repository.getTripList()
        }
    }
}