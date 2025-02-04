/*
 * Copyright (C) 2022, Kasem S.M
 * All rights reserved.
 */
package slime.com.data.models

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class SubscribedTopic(
    val userId: String,
    val topicId: String,
    val isInExplore: Boolean = false,
    @BsonId
    val id: String = ObjectId().toString()
)
