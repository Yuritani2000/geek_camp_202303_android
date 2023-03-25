package com.example.geek202303

import android.os.Bundle
import android.content.Context
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.res.TypedArrayUtils.getText
import com.example.geek202303.R
import com.example.geek202303.ui.theme.Geek202303Theme

class ResisterUserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResisterUserUI()
        }
    }
}

@Composable
fun ResisterUserUI(){
    // 各入力フォームの記述内容を持つ
    val userName = remember{ mutableStateOf("") }
    val studentId = remember{ mutableStateOf("") }
    val password = remember{ mutableStateOf("") }
    val passwordRe = remember{ mutableStateOf("") }

    Geek202303Theme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ){
            Column(){
                Text(
                    text = stringResource(R.string.user_name),
                    style = MaterialTheme.typography.body2
                )
                TextField(
                    value = userName.value,
                    onValueChange = { userName.value  = it },
                    label = { Text(stringResource(id = R.string.user_name)) },
                )
                Text(
                    text = stringResource(R.string.stu_id),
                    style = MaterialTheme.typography.body2
                )
                TextField(
                    value = studentId.value,
                    onValueChange = { studentId.value  = it },
                    label = { Text(stringResource(id = R.string.stu_id)) },
                )
                Text(
                    text = stringResource(R.string.password),
                    style = MaterialTheme.typography.body2
                )
                TextField(
                    value = password.value,
                    onValueChange = { password.value  = it },
                    label = { Text(stringResource(id = R.string.password)) },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
                Text(
                    text = stringResource(R.string.password_re),
                    style = MaterialTheme.typography.body2
                )
                TextField(
                    value = passwordRe.value,
                    onValueChange = { passwordRe.value  = it },
                    label = { Text(stringResource(id = R.string.password_re)) },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ResisterUserUIPreview(){
    ResisterUserUI()
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Geek202303Theme {
        Greeting2("Android")
    }
}

//@Composable
//fun Form(str: String, label: ){
//    val fieldValue = remember { mutableStateOf(str) }
//    TextField(
//        value = fieldValue.value,
//        onValueChange = { newValue: String ->
//            fieldValue.value = newValue
//        }
//    )
//}

//@Composable
//@Preview
//fun FormPreview(){
//    Form(str="キョン")
//}