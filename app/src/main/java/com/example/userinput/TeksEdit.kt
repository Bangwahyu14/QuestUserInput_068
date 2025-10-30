package com.example.userinput

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun FormDataDiri(modifier: Modifier
){
    var texsNama by remember { mutableStateOf(value = "") }
    var texsAlamat by remember { mutableStateOf(value = "") }
    var texstJK by remember {mutableStateOf("")}

}