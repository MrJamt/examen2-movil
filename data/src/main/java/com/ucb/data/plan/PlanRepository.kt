package com.ucb.data.plan

import com.ucb.domain.Plan

class PlanRepository(
    private val planLocalDataSource: IPlanLocalDataSource,
) {
    suspend fun getPlans(): List<Plan> = planLocalDataSource.getPlans()
}
