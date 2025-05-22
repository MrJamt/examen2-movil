@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.ucb.ucbtest.plan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucb.domain.Plan
import com.ucb.usecases.plan.GetPlans
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val getPlans: GetPlans,
    ) : ViewModel() {
        sealed class HomeUIState {
            object Loading : HomeUIState()

            class Loaded(
                val plans: List<Plan>,
            ) : HomeUIState()

            class Error(
                val message: String,
            ) : HomeUIState()
        }

        private val _state = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
        val state: StateFlow<HomeUIState> = _state

        fun loadPlans() {
            _state.value = HomeUIState.Loading
            viewModelScope.launch {
                try {
                    val plans = getPlans.invoke()
                    _state.value = HomeUIState.Loaded(plans)
                } catch (e: Exception) {
                    e.printStackTrace()
                    _state.value = HomeUIState.Error("Error cargando planes: ${e.message}")
                }
            }
        }
    }
