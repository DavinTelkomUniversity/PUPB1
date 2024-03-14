package org.d3if3003.mobpro1

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.d3if3003.mobpro1.ui.theme.DavinTheme
// DAVIN WAHYU WARDANA
// 6706223003
// D3IF-4603

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { padding ->
        ScreenContent(Modifier.padding(padding))
    }
}

@Composable
fun ScreenContent(modifier: Modifier) {
    var alas by remember { mutableStateOf("") }
    var alasError by remember { mutableStateOf(false) }

    var tinggi by remember { mutableStateOf("") }
    var tinggiError by remember { mutableStateOf(false) }

    var sisi by remember { mutableStateOf("") }
    var sisiError by remember { mutableStateOf(false) }

    var luas by remember { mutableStateOf(0f) }
    var keliling by remember { mutableStateOf(0f) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.jajar_genjang_intro),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth()
        )
        Column {
            OutlinedTextField(
                value = alas,
                onValueChange = {
                    alas = it
                },
                label = { Text(text = "Alas") },
                isError = alasError,
                trailingIcon = { IconPicker(alasError, "cm") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth(),
            )
            if (alasError) {
                Text(
                    text = "Input alas tidak valid",
                    color = Color.Red,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }

        Column {
            OutlinedTextField(
                value = tinggi,
                onValueChange = {
                    tinggi = it
                },
                label = { Text(text = "Tinggi") },
                isError = tinggiError,
                trailingIcon = { IconPicker(tinggiError, "cm") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth(),
            )
            if (tinggiError) {
                Text(
                    text = "Input tinggi tidak valid",
                    color = Color.Red,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }

        Column {
            OutlinedTextField(
                value = sisi,
                onValueChange = {
                    sisi = it
                },
                label = { Text(text = "Sisi") },
                isError = sisiError,
                trailingIcon = { IconPicker(sisiError, "cm") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.fillMaxWidth(),
            )
            if (sisiError) {
                Text(
                    text = "Input sisi tidak valid",
                    color = Color.Red,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    alasError = (alas == "" || alas == "0")
                    tinggiError = (tinggi == "" || tinggi == "0")
                    sisiError = (sisi == "" || sisi == "0")
                    if (alasError || tinggiError || sisiError) return@Button

                    val calculatedLuas = hitungLuas(alas.toFloat(), tinggi.toFloat())
                    val calculatedKeliling = hitungKeliling(alas.toFloat(), tinggi.toFloat(), sisi.toFloat())

                    luas = calculatedLuas
                    keliling = calculatedKeliling

                },
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(R.string.hitung))
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = {
                    alas = ""
                    tinggi = ""
                    sisi = ""
                    luas = 0f
                    keliling = 0f
                },
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Reset")
            }
        }




        if (luas != 0f || keliling != 0f) {
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp
            )
            Text(
                text = "Luas: $luas",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Keliling: $keliling",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun IconPicker(isError: Boolean, unit: String) {
    if (isError) {
        Icon(imageVector = Icons.Filled.Warning, contentDescription = null)
    } else {
        Text(text = unit)
    }
}

private fun hitungLuas(alas: Float, tinggi: Float): Float {
    return alas * tinggi
}

private fun hitungKeliling(alas: Float, tinggi: Float, sisi: Float): Float {
    return 2 * (alas + tinggi)
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ScreenPreview() {
    DavinTheme {
        MainScreen()
    }
}