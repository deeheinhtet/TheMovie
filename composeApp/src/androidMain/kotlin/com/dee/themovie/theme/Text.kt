package com.dee.themovie.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Created by Hein Htet
 */


private val defaultTextStyle =
    TextStyle(fontFamily = robotoMonoFamily, fontWeight = FontWeight.Medium)
private val mediumTextStyle =
    TextStyle(fontFamily = robotoMonoFamily, fontWeight = FontWeight.Medium)
private val semiBoldTextStyle =
    TextStyle(fontFamily = robotoMonoFamily, fontWeight = FontWeight.SemiBold)
private val boldTextStyle = TextStyle(fontFamily = robotoMonoFamily, fontWeight = FontWeight.Bold)


private val text10Style = TextStyle(fontSize = 10.sp)
private val text12Style = TextStyle(fontSize = 12.sp)
private val text14Style = TextStyle(fontSize = 14.sp)
private val text16Style = TextStyle(fontSize = 16.sp)


// text 10
@Composable
fun Text10(text: String, modifier: Modifier = Modifier, textStyle: TextStyle = TextStyle()) {
    Text(
        modifier = modifier, text = text,
        style = defaultTextStyle.merge(text10Style).merge(textStyle)
    )
}

@Composable
fun Text10Medium(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(mediumTextStyle).merge(text10Style)
    )
}

@Composable
fun Text10SemiBold(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(semiBoldTextStyle).merge(text10Style)
    )
}


@Composable
fun Text10Bold(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(boldTextStyle).merge(text10Style)
    )
}


// text 12


@Composable
fun Text12(text: String, modifier: Modifier = Modifier, textStyle: TextStyle = TextStyle()) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(defaultTextStyle).merge(text12Style)
    )
}

@Composable
fun Text12Medium(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(mediumTextStyle).merge(text12Style)
    )
}

@Composable
fun Text12SemiBold(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(semiBoldTextStyle).merge(text12Style)
    )
}


@Composable
fun Text12Bold(
    text: String,
    modifier: Modifier = Modifier,
    maxLine: Int = 1,
    textStyle: TextStyle = TextStyle(),
) {
    Text(
        modifier = modifier, text = text,
        maxLines = maxLine,
        style = textStyle.merge(boldTextStyle).merge(text12Style),
    )
}

// text 14


@Composable
fun Text14(text: String, modifier: Modifier = Modifier, textStyle: TextStyle = TextStyle()) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(defaultTextStyle).merge(text14Style)
    )
}

@Composable
fun Text14Medium(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(mediumTextStyle).merge(text14Style)
    )
}

@Composable
fun Text14SemiBold(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(semiBoldTextStyle).merge(text14Style)
    )
}


@Composable
fun Text14Bold(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(boldTextStyle).merge(text14Style)
    )
}


// text 16


@Composable
fun Text16(text: String, modifier: Modifier = Modifier, textStyle: TextStyle = TextStyle()) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(defaultTextStyle).merge(text16Style)
    )
}

@Composable
fun Text16Medium(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(mediumTextStyle).merge(text16Style)
    )
}

@Composable
fun Text16SemiBold(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Text(
        modifier = modifier, text = text,
        style = textStyle.merge(semiBoldTextStyle).merge(text16Style)
    )
}


@Composable
fun Text16Bold(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
) {
    Text(
        modifier = modifier, text = text,
        style = boldTextStyle.merge(boldTextStyle).merge(textStyle)
    )
}
