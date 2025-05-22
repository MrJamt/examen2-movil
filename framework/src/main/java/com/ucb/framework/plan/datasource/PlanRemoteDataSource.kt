package com.ucb.framework.plan.datasource

import android.content.Context
import com.ucb.data.plan.IPlanLocalDataSource
import com.ucb.domain.Plan

class PlanRemoteDataSource(
    val context: Context,
) : IPlanLocalDataSource {
    override suspend fun getPlans(): List<Plan> =
        listOf(
            Plan(5, 270, 199, 5),
            Plan(6, 300, 229, 6),
            Plan(7, 350, 259, 7),
        )
}
