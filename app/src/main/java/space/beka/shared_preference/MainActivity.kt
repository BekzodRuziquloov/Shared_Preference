package space.beka.shared_preference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import space.beka.shared_preference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val sharedPreferences = getSharedPreferences("SharedPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        binding.apply {
            btnSave.setOnClickListener {
                val username = edtName.text.toString()
                val useremail = edtEmail.text.toString()

                editor.apply {
                    putString("user_name", username)
                    putString("user_email", useremail)
                    apply()
                }
            }
            btnLoad.setOnClickListener {
                val userName = sharedPreferences.getString("user_name", "NOT FOUND")
                val userEmail = sharedPreferences.getString("user_email", "NOT FOUND")

                tvName.text = userName
                tvEmail.text = userEmail
            }
        }


//        sharedPreference.init(this)
//
//        binding.btnSave.setOnClickListener{
//            sharedPreference.myName=it.toString()
//            sharedPreference.myEmail=it.toString()
//        }
//        binding.btnLoad.setOnClickListener{
//            loadData()
//        }
//
//
//    }
//    private fun loadData(){
//        binding.tvName.text=sharedPreference.myName
//        binding.tvEmail.text=sharedPreference.myEmail
//    }
    }
}