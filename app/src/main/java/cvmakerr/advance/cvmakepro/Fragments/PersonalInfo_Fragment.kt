package cvmakerr.advance.cvmakepro.Fragments


import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Shared_Prefrence.SharedPrefMain
import kotlinx.android.synthetic.main.fragment_personal_info_.*
import java.io.ByteArrayOutputStream
import java.util.*


class PersonalInfo_Fragment : Fragment() {

var sharedPrefMain: SharedPrefMain? = null;
    private val RESULT_LOAD_IMAGE = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_info_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

sharedPrefMain= activity?.let { SharedPrefMain(it) }

        //init
        ed_name.setText("" + sharedPrefMain?.getname())
        ed_father.setText("" + sharedPrefMain?.getfathername())
        ed_date.setText("" + sharedPrefMain?.getdob())
        ed_address.setText("" + sharedPrefMain?.getaddress())
        ed_phone.setText("" + sharedPrefMain?.getphone())
        ed_email.setText("" + sharedPrefMain?.getemail())
        ed_professional.setText("" + sharedPrefMain?.getprofession())

        ed_nationality.setText("" + sharedPrefMain?.getnatinality())
        ed_cnic.setText("" + sharedPrefMain?.getnic())
        ed_status.setText("" + sharedPrefMain?.getstatus())
        ed_website.setText("" + sharedPrefMain?.getweb())

        if (sharedPrefMain?.getimg().equals("0")) {
          profile_image.setImageResource(R.drawable.icon_profile)
        } else {
            btmap =decodeBase642(sharedPrefMain?.getimg())
            profile_image.setImageBitmap(btmap)
        }



        //Text_______Watchers
        ed_name.addTextChangedListener(textWatcher_name)
        ed_father.addTextChangedListener(textWatcher_father)
        ed_address.addTextChangedListener(textWatcher_address)
        ed_date.addTextChangedListener(textWatcher_date)
        ed_phone.addTextChangedListener(textWatcher_phone)
        ed_email.addTextChangedListener(textWatcher_email)
        ed_professional.addTextChangedListener(textWatcher_professional)
        ed_nationality.addTextChangedListener(textWatcher_nationality)
        ed_cnic.addTextChangedListener(textWatcher_cnic)
        ed_status.addTextChangedListener(textWatcher_status)
        ed_website.addTextChangedListener(textWatcher_website)
//

        profile_image.setOnClickListener(View.OnClickListener {
            try { //go to image library and pick the image
                val i = Intent(
                    Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                )
                startActivityForResult(
                    i,
                    RESULT_LOAD_IMAGE
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }

        })


        ///calender


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        imgcalender.setOnClickListener(View.OnClickListener {
            val dpd = activity?.let {
                DatePickerDialog(
                    it,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        // Display Selected date in TextView
                        ed_date.setText("" + dayOfMonth + "/" + monthOfYear + "/" + year)
                        sharedPrefMain?.setdob("" + dayOfMonth + "/" + monthOfYear + "/" + year)
                    },
                    year,
                    month,
                    day
                )
            }
            if (dpd != null) {
                dpd.show()
            }

        })



    }

    private val textWatcher_name = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
          sharedPrefMain?.setname("" + s)
            if (start == 30) {
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
            sharedPrefMain?.setfathername("" + s)
            if (start == 30) {
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
            sharedPrefMain?.setaddress("" + s)
            if (start == 80) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private val textWatcher_phone = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            sharedPrefMain?.setphone("" + s)
            if (start == 30) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private val textWatcher_email = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            sharedPrefMain?.setemail("" + s)
            if (start == 30) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private val textWatcher_professional = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            sharedPrefMain?.setprofession("" + s)
            if (start == 30) {
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
            sharedPrefMain?.setdob("" + s)
            if (start == 30) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private val textWatcher_cnic = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            sharedPrefMain?.setnic("" + s)
            if (start == 30) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private val textWatcher_status = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            sharedPrefMain?.setstatus("" + s)
            if (start ==20) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private val textWatcher_website = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            sharedPrefMain?.setweb("" + s)
            if (start == 100) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private val textWatcher_nationality = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            sharedPrefMain?.setnatinality("" + s)
            if (start ==30) {
                Toast.makeText(activity, "Maximum Limit Reached", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    var btmap: Bitmap? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == Activity.RESULT_OK && null != data) {
            val selectedImage = data.data
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
            val cursor =
                activity!!.contentResolver.query(selectedImage!!, filePathColumn, null, null, null)
            cursor!!.moveToFirst()
            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
            val picturePath = cursor.getString(columnIndex)
            cursor.close()
            profile_image.setImageBitmap(BitmapFactory.decodeFile(picturePath))
            btmap = BitmapFactory.decodeFile(picturePath) //decode method called
         sharedPrefMain?.setimg(encodeTobase642(btmap))
        }
    }

    fun encodeTobase642(image: Bitmap?): String? {
        val baos = ByteArrayOutputStream()
        image!!.compress(Bitmap.CompressFormat.PNG, 50, baos)
        val b = baos.toByteArray()

        //    Log.d("Image Log:", imageEncoded);
        return Base64.encodeToString(b, Base64.DEFAULT)
    }

    fun decodeBase642(input: String?): Bitmap? {
        val decodedByte = Base64.decode(input, 0)
        return BitmapFactory
            .decodeByteArray(decodedByte, 0, decodedByte.size)
    }
}