package com.example.photogrid.presenter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.photogrid.domain.DataSource
import com.example.photogrid.domain.Topic
import com.example.photogrid.R


@Composable
fun PhotoGridApp() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier.fillMaxSize().padding(6.dp)
    ) {
        items(DataSource.topics.size) { topic ->
            PhotoCard(DataSource.topics[topic])
        }
    }


}

@Composable
fun PhotoCard(
    topic: Topic
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.height(68.dp)) {
            Image(
                painter = painterResource(id = topic.imageSource),
                contentDescription = stringResource(id = topic.stringSource),
                modifier = Modifier
                    .fillMaxHeight()
                    .width(68.dp)
            )
            Column(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp,
                        bottom = 8.dp

                        )
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = topic.stringSource),
                    style = MaterialTheme.typography.body2
                )
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = "ic grain",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = topic.count.toString(),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }

    }
}
@Preview
@Composable
fun PhotoGridAppPreview() {
    PhotoGridApp()
}



@Preview
@Composable
fun PhotoCardPreview() {
    PhotoCard(topic = DataSource.topics[0])
}
