package com.example.dynamic_content

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dynamic_content.ui.theme.Dynamic_ContentTheme

//var nameList:ArrayList<String> = arrayListOf("Vaishnavi", "Raghav", "Rishu", "Ash")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
MainScreen()
            }
        }
    }

@Composable
fun MainScreen()
{
    val greetingListstate=
        remember {  mutableStateListOf<String>("Vaishnavi", "Raghav")
        }
    val newNameStateValue= remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
        GreetingList(greetingListstate, {greetingListstate.add(newNameStateValue.value)},
            newNameStateValue.value, {newname -> newNameStateValue.value=newname })
//        for (name in names) {
//            Greeting(name = name)
//    }
//        Button(onClick ={ nameList.add("new name")} ) {
//            Text("add new name")
//        }

    }
}

@Composable
fun GreetingList(nameList: List<String>, buttonClick: ()->Unit,
                 textfieldvalue:String, textfildupdate:(newname:String)->Unit)
{
//    val greetingListstate=
//        remember {  mutableStateListOf<String>("Vaishnavi", "Raghav")
//        }
    for (name in nameList) {
        Greeting(name = name)
    }
//val newNameStateValue= remember { mutableStateOf("") }
    TextField( value = textfieldvalue,
        onValueChange =textfildupdate)

    Button(onClick =buttonClick ) {
        Text("add new name")
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!",
        style = MaterialTheme.typography.headlineSmall
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}