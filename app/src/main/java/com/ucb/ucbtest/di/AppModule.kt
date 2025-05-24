package com.ucb.ucbtest.di

import android.content.Context
import com.ucb.data.plan.IPlanLocalDataSource
import com.ucb.data.plan.PlanRepository
import com.ucb.framework.plan.datasource.PlanRemoteDataSource
import com.ucb.framework.service.RetrofitBuilder
import com.ucb.usecases.plan.GetPlans
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providerRetrofitBuilder(
        @ApplicationContext context: Context,
    ): RetrofitBuilder = RetrofitBuilder(context)

    @Provides
    @Singleton
    fun providePlanLocalDataSource(
        @ApplicationContext context: Context,
    ): IPlanLocalDataSource = PlanRemoteDataSource(context)

    @Provides
    @Singleton
    fun providePlanRepository(localDataSource: IPlanLocalDataSource): PlanRepository = PlanRepository(localDataSource)

    @Provides
    @Singleton
    fun provideGetPlans(planRepository: PlanRepository): GetPlans = GetPlans(planRepository)
}
