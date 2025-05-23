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
            Plan(8, 370, 299, 8),
            Plan(10, 470, 399, 10),
        )
}
