package me.asiimwedismas.startelecom.core.model

abstract class BaseDocument {
    abstract val date: String
    abstract val utc: Long
    abstract val document_id: String
    abstract val document_author_id: String
    abstract val document_author_name: String
    abstract val isLocked: Boolean
}