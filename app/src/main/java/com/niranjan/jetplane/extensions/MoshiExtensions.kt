package com.niranjan.jetplane.extensions

import com.squareup.moshi.Moshi
import okio.BufferedSource


val defaultMoshi = Moshi.Builder().build()

fun <T : Any> Moshi.toJson(clazz: Class<T>, value: T): String {
    val jsonAdapter = adapter(clazz)
    return jsonAdapter.toJson(value)
}

inline fun <reified T : Any> Moshi.toJson(value: T): String {
    return toJson(T::class.java, value)
}

fun <T: Any> Moshi.fromJson(
    clazz: Class<T>,
    value: String,
    lenient: Boolean = true,
    failOnUnknown: Boolean = true
): T? {
    return try {
        var jsonAdapter = adapter(clazz)

        if (failOnUnknown)
            jsonAdapter = jsonAdapter.failOnUnknown()
        if (lenient)
            jsonAdapter = jsonAdapter.lenient()

        jsonAdapter.fromJson(value)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

inline fun <reified T : Any> Moshi.fromJson(
    value: String,
    lenient: Boolean = true,
    failOnUnknown: Boolean = true
): T? {
    return fromJson(
        T::class.java,
        value,
        lenient,
        failOnUnknown
    )
}


inline fun <reified T : Any> Moshi.fromJson(
    value: BufferedSource?,
    lenient: Boolean = true,
    failOnUnknown: Boolean = true
): T? {
    return if (value == null) {
        null
    } else {
        try {
            var jsonAdapter = adapter(T::class.java)

            if (failOnUnknown)
                jsonAdapter = jsonAdapter.failOnUnknown()
            if (lenient)
                jsonAdapter = jsonAdapter.lenient()

            jsonAdapter.fromJson(value)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
