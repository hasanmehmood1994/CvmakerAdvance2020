package cvmakerr.advance.cvmakepro.Fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Shared_Prefrence.SharedPrefMain
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_reference_.*

class Reference_Fragment : Fragment() {
    var sharedPrefMain: SharedPrefMain? = null;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reference_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefMain= activity?.let { SharedPrefMain(it) }
        ed_reference.setText("" + sharedPrefMain?.getref())
        ed_reference.addTextChangedListener(textWatcher_reference)

    }
    private val textWatcher_reference = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            sharedPrefMain?.setref("" + s)
            if (start == 30) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}