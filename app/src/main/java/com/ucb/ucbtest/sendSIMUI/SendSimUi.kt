package com.ucb.ucbtest.sendSIMUI

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import com.ucb.ucbtest.R

@Suppress("ktlint:standard:function-naming")
@Composable
fun SendSimUI(viewModel: SendSimViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val referencePhone = viewModel.referencePhone
    val latitude = viewModel.latitude
    val longitude = viewModel.longitude
    val cameraPosition =
        rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(LatLng(-16.5, -68.15), 14f)
        }

    LaunchedEffect(cameraPosition.position) {
        viewModel.updateCoordinates(
            cameraPosition.position.target.latitude,
            cameraPosition.position.target.longitude,
        )
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
    ) {
        Text("Donde enviaremos tu SIM", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Divider(modifier = Modifier.padding(vertical = 8.dp), color = Color.Black)

        OutlinedTextField(
            value = referencePhone.value,
            onValueChange = { viewModel.updatePhone(it) },
            label = { Text("Teléfono de Referencia") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = latitude.value,
                onValueChange = {},
                label = { Text("Latitud") },
                readOnly = true,
                modifier = Modifier.weight(1f),
            )
            Spacer(Modifier.width(8.dp))
            OutlinedTextField(
                value = longitude.value,
                onValueChange = {},
                label = { Text("Longitud") },
                readOnly = true,
                modifier = Modifier.weight(1f),
            )
        }

        Spacer(Modifier.height(16.dp))

        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(300.dp),
        ) {
            GoogleMap(
                modifier = Modifier.matchParentSize(),
                cameraPositionState = cameraPosition,
                uiSettings = MapUiSettings(zoomControlsEnabled = false),
            )

            Icon(
                painter = painterResource(id = R.drawable.pin),
                contentDescription = null,
                modifier =
                    Modifier
                        .align(Alignment.Center)
                        .size(40.dp),
                tint = Color.Red,
            )
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { /* continuar lógica */ },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Continuar")
        }
    }
}
