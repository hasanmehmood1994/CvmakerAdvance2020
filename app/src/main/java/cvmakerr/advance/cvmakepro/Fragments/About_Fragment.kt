package cvmakerr.advance.cvmakepro.Fragments

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Shared_Prefrence.SharedPrefMain
import kotlinx.android.synthetic.main.fragment_about.*


class About_Fragment : Fragment() {
    var sharedPrefMain: SharedPrefMain? = null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefMain= activity?.let { SharedPrefMain(it) }
        ed_about.setText("" + sharedPrefMain?.getaboutme())
        ed_about.addTextChangedListener(textWatcher_about)

    }
    private val textWatcher_about = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            sharedPrefMain?.setaboutme("" + s)
            if (start == 30) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}