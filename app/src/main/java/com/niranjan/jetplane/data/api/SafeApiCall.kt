package com.niranjan.jetplane.data.api

import com.niranjan.jetplane.data.NetworkError
import com.niranjan.jetplane.data.NetworkResource
import com.niranjan.jetplane.extensions.defaultMoshi
import com.niranjan.jetplane.extensions.fromJson
import retrofit2.Response
import java.net.UnknownHostException

class SafeApiCall {

    inline fun <T, reified E: Any> safeApiCall(
        block: () -> Response<T>
    ): NetworkResource<T, E> {

        val result = runCatching(block)

        return if(result.isSuccess){
            val response = result.getOrNull()
            return response?.let {
                if(it.isSuccessful){
                    NetworkResource.Success(it.body())
                } else {
                    val errorBody = it.errorBody()
                    if(errorBody != null){
                        NetworkResource.Error(NetworkError.HttpError(response.code(), defaultMoshi.fromJson<E>(errorBody.source())))
                    } else {
                        NetworkResource.Error(NetworkError.HttpError(response.code(), null))
                    }
                }
            } ?: NetworkResource.Error(NetworkError.Unknown())
        } else{
            when(result.exceptionOrNull()){
                is UnknownHostException -> NetworkResource.Error(NetworkError.NoInternetConnectionError())
                else -> NetworkResource.Error(NetworkError.Unknown())
            }
        }
    }
}