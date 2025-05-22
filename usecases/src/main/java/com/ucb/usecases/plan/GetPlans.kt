package com.ucb.usecases.plan

import com.ucb.data.plan.PlanRepository
import com.ucb.domain.Plan

class GetPlans(
    private val planRepository: PlanRepository,
) {
    suspend fun invoke(): List<Plan> = planRepository.getPlans()
}
