package com.alpha.bookapplication.data.networking.baseRequest

import android.util.Log
import com.alpha.lazza.data.network.baseRequest.ErrorBodyModel
import com.google.gson.Gson
import kotlinx.coroutines.*
import retrofit2.Response
import java.io.IOException

object Network {

    fun <T : Any> request(
        request: suspend () -> Response<T>,
        success: ((response: T) -> Unit)?,
        error: ((errorBody: ErrorBodyModel) -> Unit)? = null
    ): Job {

        return CoroutineScope(Dispatchers.Main).launch {

            try {
                val response = request.invoke()

                withContext(Dispatchers.Main) {
                    val statusCode = response.code()
                    val isResponseSuccessful = response.isSuccessful
                    val responseBody = response.body()
                    val errorBodyMessage = response.errorBody()?.toString()

                    Log.e("NetWorkState", "status Code ${statusCode}")

                    if (isResponseSuccessful) {
                        responseBody?.let { success?.invoke(it) }
                    } else {

                        val message = response.body() as ErrorBodyModel
                        Log.e("NetWorkState", "status Code" + message.message)
                        val errorBody =
                            Gson().fromJson(errorBodyMessage, ErrorBodyModel::class.java)
                        error?.invoke(errorBody)
                    }

                }


            } catch (e: Exception) {

                withContext(Dispatchers.Main) {
                    error?.invoke(ErrorBodyModel(message = e.message.toString()))
                }

                e.let {
                    Log.e("NetWorkState", "Exception ${handleErrorBody(e)}")
                }


            }

        }


    }


    private fun handleErrorBody(e: Exception): String {

        return when (e) {
            is IOException -> // Timeout
                "common_check_connection"
            is RuntimeException -> // Unexpected Json response from server
                e.message.toString()
            else -> // Other error
                e.message.toString()
        }
    }


    /*  private fun <T : Any> verifyResponse(response: Response<T>): HandleResult<T> {

          return try {
              val isResponseSuccessful = response.isSuccessful
              val statusCode = response.code()
              val responseBody = response.body()
              val rawMessage = response.raw().message
              val errorBodyMessage = response.errorBody()?.string()

              if (isResponseSuccessful) {
                  HandleResult.Success(responseBody!!)
              } else {
                  val errorBody = Gson().fromJson(errorBodyMessage, ErrorBodyModel::class.java)
                  HandleResult.Failure(errorBody)
              }
          } catch (ex: Exception) {
              HandleResult.Failure(ErrorBodyModel(message = ex.message!!))
          }
      }*/


}