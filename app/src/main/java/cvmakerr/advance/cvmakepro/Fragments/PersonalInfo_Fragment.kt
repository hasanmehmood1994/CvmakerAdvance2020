package cvmakerr.advance.cvmakepro.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.libizo.CustomEditText
import cvmakerr.advance.cvmakepro.R


class PersonalInfo_Fragment : Fragment() {


    private lateinit var ed_name:EditText
    private lateinit var ed_father:EditText
    private lateinit var ed_date: EditText
    private lateinit var ed_address: EditText
    private lateinit var ed_nationality:EditText
    private lateinit var ed_status: EditText
    private lateinit var ed_religion:EditText
    private lateinit var ed_email: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_info_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ed_name=view.findViewById(R.id.ed_name) ;
        ed_father=view.findViewById(R.id.ed_father) ;


        //Text_______Watchers

        ed_name.addTextChangedListener(textWatcher_name)
        ed_father.addTextChangedListener(textWatcher_father)



    }
    private val textWatcher_name = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            if (start == 12) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private val textWatcher_father = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            if (start == 12) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }
    private val textWatcher_date = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            ed_father.setText(s)

            Toast.makeText(activity, ""+s, Toast.LENGTH_SHORT)
            if (start == 12) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }
    private val textWatcher_address = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
           ////here
            if (start == 12) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }
}