package cvmakerr.advance.cvmakepro

import android.os.Bundle
import cvmakerr.advance.cvmakepro.R
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activit_backdialog.*
class Dialog_backpress(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activit_backdialog)

      // btn_continue?.setOnClickListener(View.OnClickListener { dismiss() })
//        btn_exit?.setOnClickListener(View.OnClickListener { (context as Activity).finish() })
    }
}