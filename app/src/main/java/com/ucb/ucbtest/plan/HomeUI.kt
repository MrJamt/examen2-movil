@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.ucb.ucbtest.plan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF6D6D),
                        modifier = Modifier.padding(top = 30.dp),
                    )
                    Text(
                        text = "La mejor cobertura, increíbles beneficios\ny un compromiso con el planeta.",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
                    )

                    Box {
                        Card(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .background(Color.White),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Text(
                                    "Plan FLEX ${plan.planFlexNumber}",
                                    color = Color(0xFFFF6D6D),
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(bottom = 10.dp),
                                )

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Row(verticalAlignment = Alignment.Bottom) {
                                        Text(
                                            text = "Antes ",
                                            fontSize = 12.sp,
                                            color = Color.Gray,
                                        )
                                        Text(
                                            text = "$${plan.priceBefore}",
                                            fontSize = 20.sp,
                                            color = Color.Gray,
                                            fontWeight = FontWeight.Bold,
                                            modifier =
                                                Modifier.drawBehind {
                                                    val strokeWidth = 2.dp.toPx()
                                                    val y = size.height / 2
                                                    drawLine(
                                                        color = Color(0xFFFF7062),
                                                        start = Offset(0f, y),
                                                        end = Offset(size.width, y),
                                                        strokeWidth = strokeWidth,
                                                    )
                                                },
                                        )
                                        Text(
                                            text = " /mes",
                                            fontSize = 12.sp,
                                            color = Color.Gray,
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(4.dp))

                                    Row(verticalAlignment = Alignment.Bottom) {
                                        Text(
                                            text = "Ahora ",
                                            fontSize = 12.sp,
                                            color = Color.Black,
                                        )
                                        Text(
                                            text = "$${plan.priceNow}",
                                            fontSize = 32.sp,
                                            fontWeight = FontWeight.Bold,
                                        )
                                        Text(
                                            text = " /mes",
                                            fontSize = 12.sp,
                                            color = Color.Black,
                                        )
                                    }

                                    Text(
                                        text = "${plan.gbNumber}GB",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Gray,
                                        modifier = Modifier.padding(top = 4.dp),
                                    )
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                val benefits =
                                    listOf(
                                        "Llamadas y SMS ilimitados",
                                        "Hotspot. Comparte tus datos",
                                        "Redes Sociales ilimitadas incluidas",
                                        "Arma tu plan con más apps ilimitadas",
                                        "CO2 Negativo",
                                    )

                                Column(
                                    modifier =
                                        Modifier
                                            .fillMaxWidth()
                                            .padding(start = 30.dp, end = 30.dp),
                                ) {
                                    benefits.forEach {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(vertical = 6.dp),
                                        ) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.ic_check),
                                                contentDescription = null,
                                                tint = Color.Black,
                                                modifier = Modifier.size(24.dp),
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(it, fontSize = 14.sp)
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                SocialIconsRow()

                                Button(
                                    onClick = { /* Acción del botón */ },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6D6D)),
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    Text("Quiero este plan")
                                }
                            }
                        }

                        // Flecha Izquierda
                        IconButton(
                            onClick = {
                                currentIndex = if (currentIndex > 0) currentIndex - 1 else plans.lastIndex
                            },
                            modifier =
                                Modifier
                                    .align(Alignment.CenterStart)
                                    .padding(start = 8.dp)
                                    .background(color = Color(0xFFFF7062), shape = CircleShape)
                                    .size(36.dp),
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_arrow_left),
                                contentDescription = "Anterior",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp),
                            )
                        }

                        // Flecha Derecha
                        IconButton(
                            onClick = {
                                currentIndex = if (currentIndex < plans.lastIndex) currentIndex + 1 else 0
                            },
                            modifier =
                                Modifier
                                    .align(Alignment.CenterEnd)
                                    .padding(end = 8.dp)
                                    .background(color = Color(0xFFFF7062), shape = CircleShape)
                                    .size(36.dp),
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_arrow_right),
                                contentDescription = "Siguiente",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun SocialIconsRow() {
    val orderedIcons =
        listOf(
            "whatsapp",
            "facebook",
            "messenger",
            "x",
            "instagram",
            "snapchat",
            "telegram",
        )

    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        orderedIcons.forEach { name ->
            val icon = Iconos.AllIconsNamed[name]
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = name,
                    modifier =
                        Modifier
                            .size(35.dp)
                            .padding(horizontal = 4.dp),
                    tint = Color.Black,
                )
            }
        }
    }
}
