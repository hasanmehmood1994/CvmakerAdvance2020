package cvmakerr.advance.cvmakepro.cv_prefrences;

import android.content.Context;
import android.content.SharedPreferences;

public class cv_prefrence_class {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public cv_prefrence_class(Context context)
    {
        sharedPreferences=context.getSharedPreferences("cvmakerprefnbapps1",Context.MODE_PRIVATE);
        editor=  sharedPreferences.edit();
    }

    //info
    public void setname(String id) {                    editor.putString("cvname",id)         ;editor.commit(); }
    public String getname()   { return  sharedPreferences.getString("cvname","");  }

    public void setfield(String id) {                    editor.putString("cvfield",id)         ;editor.commit(); }
    public String getfield()   { return  sharedPreferences.getString("cvfield","");  }

    public void setaddress(String id) {                    editor.putString("cvaddress",id)         ;editor.commit(); }
    public String getaddress()   { return  sharedPreferences.getString("cvaddress","");  }

    public void setphone(String id) {                    editor.putString("cvphone",id)         ;editor.commit(); }
    public String getphone()   { return  sharedPreferences.getString("cvphone","");  }

    public void setmail(String id) {                    editor.putString("cvmail",id)         ;editor.commit(); }
    public String getmail()   { return  sharedPreferences.getString("cvmail","");  }

    public void setimg(String id) {                    editor.putString("cvimg",id)         ;editor.commit(); }
    public String getimg()   { return  sharedPreferences.getString("cvimg","0");  }


    public void setlang(String id) {                    editor.putString("cvlang",id)         ;editor.commit(); }
    public String getlang()   { return  sharedPreferences.getString("cvlang","");  }


    //about me
     public void setaboutme(String id) {                    editor.putString("cvaboutme",id)         ;editor.commit(); }
     public String getaboutme()   { return  sharedPreferences.getString("cvaboutme","");  }



    //skills
    public void setskills(String id) {                    editor.putString("cvskills",id)         ;editor.commit(); }
    public String getskills()   { return  sharedPreferences.getString("cvskills","");  }



    //hobby
    public void sethobby(String id) {                    editor.putString("cvhobby",id)         ;editor.commit(); }
    public String gethobby()   { return  sharedPreferences.getString("cvhobby","");  }


    //work

    public void setwork(String id) {                    editor.putString("cvwork",id)         ;editor.commit(); }
    public String getwork()   { return  sharedPreferences.getString("cvwork","");  }




}
