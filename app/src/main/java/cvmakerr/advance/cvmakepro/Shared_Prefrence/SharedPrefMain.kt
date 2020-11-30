package cvmakerr.advance.cvmakepro.Shared_Prefrence

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class SharedPrefMain(context: Context) {
    var sharedPreferences: SharedPreferences
    var editor: Editor

    //info
    fun setname(id: String?) {
        editor.putString("cvname", id)
        editor.commit()
    }

    fun getname(): String? {
        return sharedPreferences.getString("cvname", "")
    }
    fun setfathername(id: String?) {
        editor.putString("cvfname", id)
        editor.commit()
    }

    fun getfathername(): String? {
        return sharedPreferences.getString("cvfname", "")
    }
    fun setdob(id: String?) {
        editor.putString("cvdob", id)
        editor.commit()
    }

    fun getdob(): String? {
        return sharedPreferences.getString("cvdob", "")
    }

    fun setaddress(id: String?) {
        editor.putString("cvaddress", id)
        editor.commit()
    }

    fun getaddress(): String? {
        return sharedPreferences.getString("cvaddress", "")
    }

    fun setphone(id: String?) {
        editor.putString("cvphone", id)
        editor.commit()
    }

    fun getphone(): String? {
        return sharedPreferences.getString("cvphone", "")
    }

    fun setemail(id: String?) {
        editor.putString("cvmail", id)
        editor.commit()
    }

    fun getemail(): String? {
        return sharedPreferences.getString("cvmail", "")
    }

    fun setimg(id: String?) {
        editor.putString("cvimg", id)
        editor.commit()
    }

    fun getimg(): String? {
        return sharedPreferences.getString("cvimg", "0")
    }

    fun setnatinality(id: String?) {
        editor.putString("cvnatinality", id)
        editor.commit()
    }

    fun getnatinality(): String? {
        return sharedPreferences.getString("cvnatinality", "")
    }

    //about me
    fun setaboutme(id: String?) {
        editor.putString("cvaboutme", id)
        editor.commit()
    }

    fun getaboutme(): String? {
        return sharedPreferences.getString("cvaboutme", "")
    }

    //skills
    fun setnic(id: String?) {
        editor.putString("cvnic", id)
        editor.commit()
    }

    fun getnic(): String? {
        return sharedPreferences.getString("cvnic", "")
    }

    //hobby
    fun setstatus(id: String?) {
        editor.putString("cvstatus", id)
        editor.commit()
    }

    fun getstatus(): String? {
        return sharedPreferences.getString("cvstatus", "")
    }

    //work
    fun setweb(id: String?) {
        editor.putString("cvweb", id)
        editor.commit()
    }

    fun getweb(): String? {
        return sharedPreferences.getString("cvweb", "")
    }

    init {
        sharedPreferences = context.getSharedPreferences("cvmakerprefnbapps1", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }
}