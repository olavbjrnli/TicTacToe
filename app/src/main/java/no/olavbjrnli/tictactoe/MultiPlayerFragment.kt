package no.olavbjrnli.tictactoe

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class MultiPlayerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)

        val pref = activity!!.getSharedPreferences("key_name",  0)
        val editor = pref.edit()

        val btnSend: Button = view.findViewById(R.id.btnBack) as Button
        val playerNameOne: EditText = view.findViewById(R.id.nameOne) as EditText
        val playerNameTwo: EditText = view.findViewById(R.id.nameTwo) as EditText

        btnSend.setOnClickListener {
            //saves edit text player name in shared preferences on button click
            val firstPlayer = playerNameOne.text.toString()
            val secondPlayer = playerNameTwo.text.toString()
            editor.putString("key_name_one", firstPlayer)
            editor.putString("key_name_two", secondPlayer)
            editor.putInt("key_name_win", 0)
            editor.putInt("key_name_winTwo", 0)
            editor.commit()
            //switches over to another activity with button click
            val intent = Intent(activity, GameActivity::class.java)
            if(btnSend.isPressed){
                intent.putExtra("multiplayer", true)
            }
            startActivity(intent)
        }

        return view
    }
}