package space.beka.shared_preference

import android.content.Context
import android.content.SharedPreferences

object sharedPreference {

    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {

        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var myName: String?
    get()= sharedPreferences.getString("myName", "NOT FOUND")
    set(value) = sharedPreferences.edit {
        if(value!=null){
            it.putString("myName", value)
            it.commit()
        }
    }

    var myEmail: String?
        get()= sharedPreferences.getString("myEmail", "NOT FOUND")
        set(value) = sharedPreferences.edit {
            if(value!=null){
                it.putString("myEmail", value)
                it.commit()
            }
        }


}