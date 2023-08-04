/*
 * Copyright 2023 Shubham Singh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.ishubhamsingh.splashy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.ishubhamsingh.splashy.core.navigation.Screen
import dev.ishubhamsingh.splashy.models.Photo
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun PhotoCardItem(
  navigator: Navigator,
  photo: Photo,
  heightDp: Dp = 320.dp,
  widthDp: Dp = 160.dp,
  padding: Dp = 4.dp,
) {

  Card(
    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
    colors = CardDefaults.cardColors(containerColor = Color(parseColor(photo.color))),
    modifier =
      Modifier.padding(vertical = padding, horizontal = padding)
        .fillMaxWidth()
        .height(heightDp)
        .background(
          color = Color(parseColor(photo.color)) ?: MaterialTheme.colorScheme.surface,
          shape = RoundedCornerShape(16.dp)
        )
        .clickable { navigator.navigate(Screen.PhotoDetails.route) }
  ) {
    KamelImage(
      resource = asyncPainterResource(data = photo.urls.regular),
      contentDescription = photo.altDescription,
      modifier = Modifier.fillMaxSize(),
      contentScale = ContentScale.Crop
    )
  }
}

@Composable
fun LazyGridState.OnBottomReached(loadMore: () -> Unit) {
  val shouldLoadMore = remember {
    derivedStateOf {
      val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull() ?: return@derivedStateOf true

      lastVisibleItem.index == layoutInfo.totalItemsCount - 1
    }
  }

  // Convert the state into a cold flow and collect
  LaunchedEffect(shouldLoadMore) {
    snapshotFlow { shouldLoadMore.value }
      .collect {
        // if should load more, then invoke loadMore
        if (it) loadMore()
      }
  }
}

fun parseColor(colorString: String): Int {
  if (colorString[0] == '#') { // Use a long to avoid rollovers on #ffXXXXXX
    var color = colorString.substring(1).toLong(16)
    if (colorString.length == 7) { // Set the alpha value
      color = color or -0x1000000
    } else require(colorString.length == 9) { "Unknown color" }
    return color.toInt()
  }
  throw IllegalArgumentException("Unknown color")
}