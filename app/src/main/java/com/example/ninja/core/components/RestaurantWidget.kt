package com.example.ninja.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ninja.R
import com.example.ninja.core.theme.BlackText
import com.example.ninja.core.theme.BlackText2
import com.example.ninja.core.theme.GrayText2
import com.example.ninja.core.theme.MainColor
import com.example.ninja.core.theme.YellowText
import com.example.ninja.domain.models.Restaurant

@Composable
fun RestaurantWidget(
    restaurant: Restaurant,
    imageSize: Int = 76,
    isClickable: Boolean = true,
    restaurantClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .then(
                if (isClickable) Modifier.clickable { restaurantClicked() }
                else Modifier
            )) {
            Box(modifier = Modifier.padding(3.dp)) {
                Image(
                    painter = painterResource(R.drawable.restaurant),
                    null,
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(8.dp)
                        )
                        .size(imageSize.dp)
                )
            }
            RestaurantDesc(
                modifier = Modifier.padding(12.dp, 0.dp, 0.dp, 0.dp),
                restaurant
            )
        }

    }
}

@Composable
fun RestaurantDesc(modifier: Modifier = Modifier, restaurant: Restaurant) {
    Box(modifier = modifier) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = restaurant.name,
                    style = TextStyle(
                        color = BlackText,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500)
                    )
                )
                if (restaurant.isAdvertised) {
                    ADTag()
                }
            }
            Text(
                text = restaurant.types.joinToString(separator = " . "),
                style = TextStyle(
                    color = GrayText2,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(450)
                ), modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 6.dp)
            )
            Row {
                Box(modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)) {
                    Row {
                        listOf(
                            restaurant.deliveryTime,
                            restaurant.deliveryDistance,
                            restaurant.deliveryPrice
                        ).withIndex()
                            .forEach { (index, title) ->
                                RestaurantDeliveryDetails(
                                    modifier = Modifier.padding(
                                        0.dp,
                                        0.dp,
                                        8.dp,
                                        0.dp
                                    ),
                                    title,
                                    R.drawable.location,
                                    restaurant.isFreeDelivery && index == 2
                                )
                            }
                    }
                }
            }
        }
    }
}

@Composable
private fun RestaurantDeliveryDetails(
    modifier: Modifier = Modifier,
    text: String,
    icon: Int,
    isFreeDelivery: Boolean
) {
    Box(modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(icon),
                null,
                modifier = Modifier
                    .size(10.dp)
                    .padding(0.dp, 0.dp, 1.5.dp, 0.dp)
            )
            if (isFreeDelivery)
                Text(
                    text = "Free Delivery",
                    style = TextStyle(
                        color = MainColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    ),
                )
            else
                Text(
                    text = text,
                    style = TextStyle(
                        color = BlackText2,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500)
                    ),
                )
        }
    }
}

@Composable
private fun ADTag() {
    Box(
        Modifier
            .background(com.example.ninja.core.theme.ADTag)
            .clip(RoundedCornerShape(4.dp))
            .padding(5.dp)
    ) {
        Text(
            text = "AD",
            style = TextStyle(
                color = YellowText,
                fontSize = 10.sp,
                fontWeight = FontWeight(900)
            )
        )
    }
}