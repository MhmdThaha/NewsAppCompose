package com.example.newsappmvp.uiscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.newsappmvp.models.Article
import com.example.newsappmvp.models.Source
import com.example.newsappmvp.ui.theme.NewsAppMVPTheme

@Composable
fun NewsApp() {

    Scaffold(
        topBar = {
            NewsAppBar()
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),

            contentPadding = PaddingValues(16.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(10) {

                NewsCard(

                    article = Article(

                        title = "Breaking News: Android Development Growing Fast",

                        urlToImage = "https://images.unsplash.com/photo-1504711434969-e33886168f5c?w=400",

                        source = Source(
                            id = "1",
                            name = "Tech News"
                        )
                    ),

                    onClick = {}
                )
            }
        }
    }
}

@Composable
fun NewsCard(
    article: Article,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },

        shape = RoundedCornerShape(20.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = article.urlToImage,

                contentDescription = article.title,

                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(14.dp)),

                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = article.title ?: "No Title",

                    style = MaterialTheme.typography.titleMedium,

                    fontWeight = FontWeight.SemiBold,

                    maxLines = 3,

                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = article.source.name,

                    style = MaterialTheme.typography.bodySmall,

                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsCardPreview() {

    val sampleArticle = Article(

        title = "Breaking News: Android Development Growing Fast",

        urlToImage = "https://images.unsplash.com/photo-1504711434969-e33886168f5c?w=400",

        source = Source(
            id = "1",
            name = "Tech News"
        )
    )

    NewsAppMVPTheme {

        NewsCard(
            article = sampleArticle,
            onClick = {}
        )
    }
}