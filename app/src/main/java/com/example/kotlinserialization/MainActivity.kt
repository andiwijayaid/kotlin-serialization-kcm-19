package com.example.kotlinserialization

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiConfigWithGson().instance().getTodo(1)
            .enqueue(object : retrofit2.Callback<ToDo> {
                override fun onFailure(call: Call<ToDo>, t: Throwable) {
                    Log.d("FAIL", t.message.toString())
                }

                override fun onResponse(call: Call<ToDo>, response: Response<ToDo>) {
                    gsonPB.visibility = View.GONE
                    Log.d("G-RES", "A  ${response.body()}")

                    val toDo = response.body()

                    gsonUserIdTV.text = getString(R.string.user_id_format, toDo?.userId)
                    gsonIdTV.text = getString(R.string.id_format, toDo?.id)
                    gsonTitleTV.text = getString(R.string.title_format, toDo?.title)
                    gsonCompletedTV.text =
                        getString(R.string.commented_format, toDo?.completed.toString())
                    gsonNumberOfClickTV.text =
                        getString(R.string.number_of_click_format, toDo?.numberOfClick.toString())
                    gsonPlaceTV.text = getString(R.string.place_format, toDo?.place)
                }

            })

        ApiConfigWithKotlinSerialization().instance().getTodo(1)
            .enqueue(object : retrofit2.Callback<ToDo> {
                override fun onFailure(call: Call<ToDo>, t: Throwable) {
                    Log.d("FAIL", t.message.toString())
                }

                override fun onResponse(call: Call<ToDo>, response: Response<ToDo>) {
                    jsonPB.visibility = View.GONE
                    Log.d("KxS-RES", "A  ${response.body()}")

                    val toDo = response.body()

                    jsonUserIdTV.text = getString(R.string.user_id_format, toDo?.userId)
                    jsonIdTV.text = getString(R.string.id_format, toDo?.id)
                    jsonTitleTV.text = getString(R.string.title_format, toDo?.title)
                    jsonCompletedTV.text =
                        getString(R.string.commented_format, toDo?.completed.toString())
                    jsonNumberOfClickTV.text =
                        getString(R.string.number_of_click_format, toDo?.numberOfClick.toString())
                    jsonPlaceTV.text = getString(R.string.place_format, toDo?.place)
                }

            })
    }
}