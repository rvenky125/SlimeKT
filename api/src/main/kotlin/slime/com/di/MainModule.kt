/*
 * Copyright (C) 2022, Kasem S.M
 * All rights reserved.
 */
package slime.com.di

import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo
import slime.com.data.repository.article.ArticleRepository
import slime.com.data.repository.article.ArticleRepositoryImpl
import slime.com.data.repository.auth.AuthRepository
import slime.com.data.repository.auth.AuthRepositoryImpl
import slime.com.data.repository.recommendedtopic.RecommendedTopicRepository
import slime.com.data.repository.recommendedtopic.RecommendedTopicRepositoryImpl
import slime.com.data.repository.subscribedtopic.SubscribeTopicsRepository
import slime.com.data.repository.subscribedtopic.SubscribeTopicsRepositoryImpl
import slime.com.data.repository.topic.TopicRepository
import slime.com.data.repository.topic.TopicRepositoryImpl
import slime.com.isDebugMode
import slime.com.service.SubscriptionService
import slime.com.utils.DATABASE_NAME

val mainModule = module(createdAtStart = true) {
    single {
        val url = if (isDebugMode) "mongodb://localhost" else System.getenv("CONNECTION_STRING")
        val client = KMongo.createClient(url).coroutine
        client.getDatabase(DATABASE_NAME)
    }
    single {
        SubscriptionService(get(), get(), get())
    }
    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }
    single<ArticleRepository> {
        ArticleRepositoryImpl(get(), get())
    }
    single<TopicRepository> {
        TopicRepositoryImpl(get())
    }
    single<SubscribeTopicsRepository> {
        SubscribeTopicsRepositoryImpl(get())
    }
    single<RecommendedTopicRepository> {
        RecommendedTopicRepositoryImpl(get())
    }
}
