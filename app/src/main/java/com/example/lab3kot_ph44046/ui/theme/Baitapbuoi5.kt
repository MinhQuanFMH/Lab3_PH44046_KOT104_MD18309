package com.example.lab3kot_ph44046.ui.theme

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.lab3kot_ph44046.R

class Baitapbuoi5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldExample()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    val selectedMethod = rememberSaveable { mutableStateOf<PaymentMethod?>(null) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        text = "Thanh toán",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.DarkGray,
                contentColor = Color.White,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    BottomNavigationItem(iconRes = R.drawable.ic_home, label = "Trang chủ")
                    BottomNavigationItem(iconRes = R.drawable.ic_history, label = "Lịch sử")
                    BottomNavigationItem(iconRes = R.drawable.ic_cart, label = "Giỏ hàng")
                    BottomNavigationItem(iconRes = R.drawable.ic_profile, label = "Hồ sơ")
                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = "Địa chỉ nhận hàng",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF607D8B)
            )
            PaymentScreenContent()
            Text(
                text = "Vui lòng chọn một trong những phương thức sau:",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF35454D)
            )
            PaymentMethodsGrid(paymentMethods, selectedMethod) { paymentMethod ->
                selectedMethod.value = paymentMethod
                Log.d("Lựa chọn phương thức thanh toán", paymentMethod.name)
            }
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(100.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                Button(
//                    onClick = { /* Handle click */ },
//                    modifier = Modifier.height(50.dp),
//                    colors = ButtonDefaults.buttonColors(Color(0xFFFFA000))
//                ) {
//                    Text(text = "Tiếp theo")
//                }
//                Button(
//                    modifier = Modifier
//                        .align(Alignment.BottomCenter)
//                        .padding(40.dp)
//                        .fillMaxWidth(),
//                    shape = RoundedCornerShape(10.dp),
//                    colors = ButtonDefaults.buttonColors(containerColor = Color("#ED7B57".toColorInt())),
//
//                    onClick = { /*TODO*/
//                    }) {
//                    Text(text = "Tiếp theo")
//                }
//            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),  // Tăng chiều cao của Box để Button có đủ không gian hiển thị

                contentAlignment = Alignment.BottomCenter  // Đặt contentAlignment để Button được đặt ở cuối Box
            ) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)  // Giảm padding để Button không bị đẩy ra ngoài
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFED7B57)),
                    onClick = { /* TODO */ }
                ) {
                    Text(text = "Tiếp theo", style = TextStyle(fontSize = 16.sp))
                }
            }
        }
    }
}

@Composable
fun BottomNavigationItem(iconRes: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { /* Handle click */ }
    ) {
        Icon(painter = painterResource(id = iconRes), contentDescription = label)
        Text(text = label)
    }
}

@Preview
@Composable
fun PreviewScreen() {
    ScaffoldExample()
}

@Composable
fun PaymentScreenContent() {
    Column(
        modifier = Modifier.padding(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .padding(vertical = 10.dp),
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "Location"
            )
            Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                Text(
                    text = "Quan | 10032004",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "22/333 đường Trung Mỹ Tây 1, phường Tân Thới Nhất, quận 12, Thành phố Hồ Chí Minh",
                    color = Color(0xFF795548),
                    fontSize = 16.sp
                )
            }
        }
    }
}

data class PaymentMethod(
    val id: Int,
    val icon: Int,
    val name: String,
    val backgroundColor: Color
)

val paymentMethods = listOf(
    PaymentMethod(1, R.drawable.ic_paypal, "PayPal", Color(0xFFFFA000)),
    PaymentMethod(2, R.drawable.ic_visa, "VISA", Color(0xFFFFFFFF)),
    PaymentMethod(3, R.drawable.ic_momo, "Momo", Color(0xFFFF4081)),
    PaymentMethod(4, R.drawable.ic_zalopay, "ZaloPay", Color(0xFF03A9F4)),
    PaymentMethod(5, R.drawable.ic_direct_payment, "Thanh toán trực tiếp", Color(0xFF00BCD4))
)

@Composable
fun PaymentMethodItem(paymentMethod: PaymentMethod, isSelected: Boolean, onSelected: (PaymentMethod) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onSelected(paymentMethod) }
            .background(if (isSelected) Color(0xFFE0F7FA) else Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .background(paymentMethod.backgroundColor),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 10.dp),
                painter = painterResource(id = paymentMethod.icon),
                contentDescription = paymentMethod.name
            )
            Text(
                text = paymentMethod.name,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            )
            Box(
                modifier = Modifier
                    .padding(end = 15.dp)
                    .size(24.dp)
                    .border(
                        width = 2.dp,
                        color = if (isSelected) Color.Red else Color.Gray,
                        shape = CircleShape
                    )
                    .background(
                        color = if (isSelected) Color.Red else Color.White,
                        shape = CircleShape
                    )
            )
        }
    }
}

@Composable
fun PaymentMethodsGrid(
    paymentMethods: List<PaymentMethod>,
    selectedMethod: MutableState<PaymentMethod?>,
    onPaymentMethodSelected: (PaymentMethod) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(paymentMethods) { paymentMethod ->
            PaymentMethodItem(
                paymentMethod,
                isSelected = paymentMethod == selectedMethod.value,
                onSelected = onPaymentMethodSelected
            )
        }
    }
}