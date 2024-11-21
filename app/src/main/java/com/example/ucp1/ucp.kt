package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable //rounder
fun Tampilan(modifier: Modifier = Modifier) {
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally){

        TampilanHeader()

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            "Plan Your Adventure",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,

        )
        Spacer(modifier = Modifier.padding(6.dp))

        Text(
            "Let's Plan an Exquisite adventure ",
            fontSize = 12.sp, color = Color.LightGray
        )

        var origin by remember { mutableStateOf(" ") }
        var departure by remember { mutableStateOf(" ") }
        var arrival by remember { mutableStateOf(" ") }

        var inputorigin by remember { mutableStateOf(" ") }
        var inputdeparture by remember { mutableStateOf(" ") }
        var inputarrival by remember { mutableStateOf(" ") }

        var jenisT by remember { mutableStateOf("") }
        var inputJenisT by remember { mutableStateOf("") } // var (Variable - Mutable), Nilai dari variabel var dapat diubah sepanjang kode berjalan.
        val inputTr = listOf("Bus","Ship", "Train", "Plane")

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = origin,
            onValueChange = {origin= it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(3.dp),
            label = { Text("Origin") },
            placeholder = { Text("Masukkan Origin ") },
            shape = RoundedCornerShape(16.dp)
        )

        Row() {
            OutlinedTextField(
                value = departure,
                onValueChange = {departure= it},

                label = { Text("Departure") },
                placeholder = { Text("Masukkan Departure Anda") },
                shape = RoundedCornerShape(16.dp)
            )

            OutlinedTextField(
                value = arrival,
                onValueChange = {arrival= it},
                modifier = Modifier
                    .padding(3.dp),
                label = { Text("Arrival") },
                placeholder = { Text("Masukkan Arrival Anda") },
                shape = RoundedCornerShape(16.dp)
            )
        }
        Spacer(modifier = Modifier.padding(12.dp))

        Box(modifier = Modifier.fillMaxWidth().background(color = Color.Blue)) {
            Text("Choose Transportation")
            Box(modifier = Modifier.background(color = Color.LightGray)) {
                Row {
                    inputTr.forEach { selectedTR ->
                        Row (verticalAlignment = Alignment.CenterVertically){
                            RadioButton(selected = jenisT == selectedTR,
                                onClick = {
                                    jenisT = selectedTR

                                })
                            Text(selectedTR
                            )
                        }
                    }
                }
            }
        }

        Button(
            onClick = {
                inputorigin = origin
                inputJenisT =jenisT
                inputdeparture = departure
                inputarrival = arrival
            },
            modifier = Modifier.padding(vertical = 7.dp).fillMaxWidth(). background(color = Color.Blue)
        ) {
            Text("Submit", color = Color.White)
        }

        Column {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(color = Color.Blue)
            ) {
                Column {
                    InputData("Origin", inputorigin)
                    InputData("Departure", inputdeparture)

                }
            }
            Spacer(modifier = Modifier.padding(5.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)

            ) {
                Column {
                    InputData("Arrival", inputarrival)
                    InputData("Transportasi", inputdeparture)

                }
            }
        }
    }

}

@Composable
fun TampilanHeader() {
    Box(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(Color.Blue)
            .padding(top = 8.dp)
    ) {
        Column ( ) { Box (modifier = Modifier
            .background(Color.LightGray)
            .padding(10.dp),
            contentAlignment = Alignment.TopCenter){
            Image(
                modifier = Modifier.size(45.dp),
                painter = painterResource(R.drawable.foto),

                contentDescription = null
            )

            Text("Muthia Sasi", color = Color.White)
        }


        }
    }
}

@Composable
fun InputData(judul: String, isinya: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya,  modifier = Modifier
            .weight(2f)
            .align(Alignment.CenterVertically), // Menyelaraskan teks ke tengah vertikal
            textAlign = TextAlign.Center)
    }
}

