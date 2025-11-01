package com.example.userinput

import android.R.attr.text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier: Modifier
) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    val gender: List<String> = listOf("laki-laki", "perempuan")

    Column(
        modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textNama,
            onValueChange = { textNama = it },
            label = { Text(stringResource(R.string.hint_nama)) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(
            text = stringResource(R.string.jenis_kelamin),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        gender.forEach { item ->
            Row(
                modifier = Modifier
                    .selectable(
                        selected = textJK == item,
                        onClick = { textJK = item }
                    )
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = textJK == item,
                    onClick = { textJK = item }
                )
                Text(item)
            }
        }
        Text(
            text = stringResource(R.string.alamat),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = textAlamat,
            onValueChange = { textAlamat = it },
            label = { Text(stringResource(R.string.alamat)) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Button(
            onClick = {
                nama = textNama
                jenis = textJK
                alamat = textAlamat
            },
            enabled = textNama.isNotEmpty() && textAlamat.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .height(dimensionResource(R.dimen.button_height)),
            shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF673AB7))
        ) {
            Text(stringResource(R.string.submit), color = Color.White)
        }
        
        if (nama.isNotEmpty()) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Black),
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Nama   : $nama", color = Color.White)
                    Text(text = "Gender : $jenis", color = Color.White)
                    Text(text = "Alamat : $alamat", color = Color.White)
                }
            }
        }
    }
}


