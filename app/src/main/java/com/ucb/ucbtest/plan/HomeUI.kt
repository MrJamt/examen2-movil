@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.ucb.ucbtest.plan

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucb.ucbtest.R
import com.ucb.ucbtest.plan.HomeViewModel

@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeUI(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    var currentIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        viewModel.loadPlans()
    }

    when (state) {
        is HomeViewModel.HomeUIState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is HomeViewModel.HomeUIState.Error -> {
            Text("Error: ${(state as HomeViewModel.HomeUIState.Error).message}")
        }
        is HomeViewModel.HomeUIState.Loaded -> {
            val plans = (state as HomeViewModel.HomeUIState.Loaded).plans
            if (plans.isNotEmpty()) {
                val plan = plans[currentIndex]

                Column(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Nuestros planes móviles",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF6D6D),
                    )
                    Text(
                        text = "La mejor cobertura, increíbles beneficios\ny un compromiso con el planeta.",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 4.dp, bottom = 16.dp),
                    )

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                "Plan FLEX ${plan.planFlexNumber}",
                                color = Color(0xFFFF6D6D),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier.padding(top = 8.dp),
                            ) {
                                Text(
                                    text = "Antes $${plan.priceBefore}",
                                    textDecoration = TextDecoration.LineThrough,
                                    color = Color.Gray,
                                    fontSize = 14.sp,
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Ahora $${plan.priceNow}", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                            }
                            Text("${plan.gbNumber}GB", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Gray)

                            Spacer(modifier = Modifier.height(16.dp))

                            val benefits =
                                listOf(
                                    "Llamadas y SMS ilimitados",
                                    "Hotspot. Comparte tus datos",
                                    "Redes Sociales ilimitadas incluidas",
                                    "Arma tu plan con más apps ilimitadas",
                                    "CO2 Negativo",
                                )

                            benefits.forEach {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(vertical = 4.dp),
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_check),
                                        contentDescription = null,
                                        tint = Color.Black,
                                        modifier = Modifier.size(16.dp),
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(it)
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_arrow_left),
                                    contentDescription = "Anterior",
                                    modifier =
                                        Modifier
                                            .size(32.dp)
                                            .clickable {
                                                currentIndex = if (currentIndex > 0) currentIndex - 1 else plans.lastIndex
                                            },
                                )

                                Spacer(modifier = Modifier.width(32.dp))

                                Image(
                                    painter = painterResource(id = R.drawable.ic_arrow_right),
                                    contentDescription = "Siguiente",
                                    modifier =
                                        Modifier
                                            .size(32.dp)
                                            .clickable {
                                                currentIndex = if (currentIndex < plans.lastIndex) currentIndex + 1 else 0
                                            },
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = { /* Acción del botón */ },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6D6D)),
                            ) {
                                Text("Quiero este plan")
                            }
                        }
                    }
                }
            }
        }
    }
}
