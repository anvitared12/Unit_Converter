package com.example.unitconverter2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(){

        var expandedInput by remember { mutableStateOf(false)}
        var selectedInputUnit by remember{ mutableStateOf("centimeter")}
        var inputValue by remember { mutableStateOf("") } //input text field
        var outputValue by remember { mutableStateOf("") } // output text field
        var selectedOutputUnit by remember{ mutableStateOf("centimeter")}
        var expandedOutput by remember { mutableStateOf(false)}


    fun convertUnits(
        value: String,
        fromUnit: String,
        toUnit: String
    ): String
    {
        if (value.isEmpty()) return ""

        val inputDouble = value.toDoubleOrNull() ?: return "Invalid input"

        val meters = when (fromUnit){
            "centimeter" -> inputDouble/100.0
            "meter" -> inputDouble
            "foot", "feet" -> inputDouble * 0.3048
            "inches" -> inputDouble * 0.0254
            "decimeter" -> inputDouble / 10.0
            "millimeter" -> inputDouble / 1000.0
            "micrometer" -> inputDouble / 1_000_000.0
            "thou" -> inputDouble * 0.0000254
            "yard" -> inputDouble * 0.9144
            "mile" -> inputDouble * 1609.344
            "kilometre" -> inputDouble * 1000.0
            "nanometre" -> inputDouble / 1_000_000_000.0
            "angstrom" -> inputDouble / 10_000_000_000.0
            "picometer" -> inputDouble / 1_000_000_000_000.0
            "fermi" -> inputDouble / 1_000_000_000_000_000.0
            else -> inputDouble
        }

        val result = when( toUnit ){
            "centimetre" -> meters * 100.0
            "metre" -> meters
            "foot", "feet" -> meters / 0.3048
            "inches" -> meters / 0.0254
            "decimeter" -> meters * 10.0
            "millimeter" -> meters * 1000.0
            "micrometer" -> meters * 1_000_000.0
            "thou" -> meters / 0.0000254
            "yard" -> meters / 0.9144
            "mile" -> meters / 1609.344
            "kilometre" -> meters / 1000.0
            "nanometre" -> meters * 1_000_000_000.0
            "angstrom" -> meters * 10_000_000_000.0
            "picometer" -> meters * 1_000_000_000_000.0
            "fermi" -> meters * 1_000_000_000_000_000.0
            else -> meters
        }

        return if (result % 1.0 == 0.0){
            result.toLong().toString()
        }else{
            String.format("%.8f", result).trimEnd('0')
        }
    }

    LaunchedEffect(inputValue, selectedInputUnit, selectedOutputUnit) {
        outputValue = convertUnits(inputValue, selectedInputUnit, selectedOutputUnit)
    }
    Column (

        Modifier.fillMaxSize().padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        Text(text = "Unit Converter", fontSize = 30.sp)

        Spacer(Modifier.padding(20.dp))

        //user inputs the value here
        OutlinedTextField(
            value = inputValue,
            onValueChange = {inputValue = it},
            label = { Text("Enter the value")}
            )

        //whatever changes happen it will be displayed here
        OutlinedTextField(
            value = outputValue,
            onValueChange = {},
            readOnly = true,
            label = {Text("your answer will be displayed here")}
        )

        Spacer(Modifier.padding(15.dp))

        Row {

            Button(
                onClick = {expandedInput = true}
            )
            {
                Text(selectedInputUnit)
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null
                )
            }
            DropdownMenu(
                expanded = expandedInput,
                onDismissRequest = {expandedInput = false})
            {
                DropdownMenuItem(
                    text = {Text("centimetre")},
                    onClick = {
                        selectedInputUnit = "centimetre"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("metre")},
                    onClick = {
                        selectedInputUnit = "metre"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("foot")},
                    onClick = {
                        selectedInputUnit = "foot"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("feet")},
                    onClick = {
                        selectedInputUnit = "feet"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("inches")},
                    onClick = {
                        selectedInputUnit = "inches"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("decimeter")},
                    onClick = {
                        selectedInputUnit = "decimeter"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("millimeter")},
                    onClick = {
                        selectedInputUnit = "millimeter"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("micrometer")},
                    onClick = {
                        selectedInputUnit = "micrometer"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("thou")},
                    onClick = {
                        selectedInputUnit = "thou"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("yard")},
                    onClick = {
                        selectedInputUnit = "yard"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("mile")},
                    onClick = {
                        selectedInputUnit = "mile"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("kilometre")},
                    onClick = {
                        selectedInputUnit = "kilometre"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("nanometre")},
                    onClick = {
                        selectedInputUnit = "nanometre"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("angstrom")},
                    onClick = {
                        selectedInputUnit = "angstrom"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("picometer")},
                    onClick = {
                        selectedInputUnit = "picometer"
                        expandedInput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("fermi")},
                    onClick = {
                        selectedInputUnit = "fermi"
                        expandedInput = false
                    }
                )

            }

            //----------------------

            Button(
                onClick = {expandedOutput = true}
            )
            {
                Text(selectedOutputUnit)
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null
                )
            }
            DropdownMenu(
                expanded = expandedOutput,
                onDismissRequest = {expandedOutput = false})
            {
                DropdownMenuItem(
                    text = {Text("centimetre")},
                    onClick = {
                        selectedOutputUnit = "centimetre"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("metre")},
                    onClick = {
                        selectedOutputUnit = "metre"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("foot")},
                    onClick = {
                        selectedOutputUnit = "foot"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("feet")},
                    onClick = {
                        selectedOutputUnit= "feet"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("inches")},
                    onClick = {
                        selectedOutputUnit= "inches"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("decimeter")},
                    onClick = {
                        selectedOutputUnit= "decimeter"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("millimeter")},
                    onClick = {
                        selectedOutputUnit = "millimeter"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("micrometer")},
                    onClick = {
                        selectedOutputUnit = "micrometer"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("thou")},
                    onClick = {
                        selectedOutputUnit = "thou"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("yard")},
                    onClick = {
                        selectedOutputUnit = "yard"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("mile")},
                    onClick = {
                        selectedOutputUnit = "mile"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("kilometre")},
                    onClick = {
                        selectedOutputUnit = "kilometre"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("nanometre")},
                    onClick = {
                        selectedOutputUnit = "nanometre"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("angstrom")},
                    onClick = {
                        selectedOutputUnit = "angstrom"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("picometer")},
                    onClick = {
                        selectedOutputUnit = "picometer"
                        expandedOutput = false
                    }
                )
                DropdownMenuItem(
                    text = {Text("fermi")},
                    onClick = {
                        selectedOutputUnit = "fermi"
                        expandedOutput = false
                    }
                )
            }

        }


    }

}
@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}