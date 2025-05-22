package com.ucb.data.plan

import com.ucb.domain.Plan

interface IPlanLocalDataSource {
    suspend fun getPlans(): List<Plan>
}
