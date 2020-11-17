package cvmakerr.advance.cvmakepro.cv_prefrences;

import android.content.Context;
import android.content.SharedPreferences;

public class cv_education_prefclass {


        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;
        public cv_education_prefclass(Context context)
        {
            sharedPreferences=context.getSharedPreferences("cvmakerprosp1",Context.MODE_PRIVATE);
            editor=  sharedPreferences.edit();
        }

       //scho0l

        public void setschooldegreetitle(String id) {                    editor.putString("cvst",id)         ;editor.commit(); }
        public String getschooldegreetitle()   { return  sharedPreferences.getString("cvst","");  }

        public void setschoolname(String id) {                    editor.putString("cvschoolname",id)         ;editor.commit(); }
        public String getschoolname()   { return  sharedPreferences.getString("cvschoolname","");  }

        public void setschoolstartyear(String id) {                    editor.putString("cvschoolstartyear",id)         ;editor.commit(); }
        public String getschoolstartyear()   { return  sharedPreferences.getString("cvschoolstartyear","");  }

        public void setschoolendyear(String id) {                    editor.putString("cvschoolendyear",id)         ;editor.commit(); }
        public String getschoolendyear()   { return  sharedPreferences.getString("cvschoolendyear","");  }

    public void setschoolgrade(String id) {                    editor.putString("cvschoolgrade",id)         ;editor.commit(); }
    public String getschoolgrade()   { return  sharedPreferences.getString("cvschoolgrade","");  }


    public void setschoolstatus(String id) {                    editor.putString("cvschoolstatus",id)         ;editor.commit(); }
    public String getschoolstatus()   { return  sharedPreferences.getString("cvschoolstatus","0");  }



        //college
        public void setclgdegreetitle(String id) {                    editor.putString("cvct",id)         ;editor.commit(); }
        public String getclgdegreetitle()   { return  sharedPreferences.getString("cvct","");  }

        public void setclgname(String id) {                    editor.putString("cvclgname",id)         ;editor.commit(); }
        public String getclgname()   { return  sharedPreferences.getString("cvclgname","");  }

        public void setclgstartyear(String id) {                    editor.putString("cvclgstartyear",id)         ;editor.commit(); }
        public String getclgstartyear()   { return  sharedPreferences.getString("cvclgstartyear","");  }

        public void setclgendyear(String id) {                    editor.putString("cvclgendyear",id)         ;editor.commit(); }
        public String getclgendyear()   { return  sharedPreferences.getString("cvclgendyear","");  }

         public void setclggrade(String id) {                    editor.putString("cvclggrade",id)         ;editor.commit(); }
         public String getclggrade()   { return  sharedPreferences.getString("cvclggrade","");  }

    public void setclgstatus(String id) {                    editor.putString("cvclgstatus",id)         ;editor.commit(); }
    public String getclgstatus()   { return  sharedPreferences.getString("cvclgstatus","0");  }



        //uni
        public void setunidegreetitle(String id) {                    editor.putString("cvut",id)         ;editor.commit(); }
    public String getunidegreetitle()   { return  sharedPreferences.getString("cvut","");  }

    public void setuniname(String id) {                    editor.putString("cvuniname",id)         ;editor.commit(); }
    public String getuniname()   { return  sharedPreferences.getString("cvuniname","");  }

    public void setunistartyear(String id) {                    editor.putString("cvunistartyear",id)         ;editor.commit(); }
    public String getunistartyear()   { return  sharedPreferences.getString("cvunistartyear","");  }

    public void setuniendyear(String id) {                    editor.putString("cvuniendyear",id)         ;editor.commit(); }
    public String getuniendyear()   { return  sharedPreferences.getString("cvuniendyear","");  }

    public void setunigrade(String id) {                    editor.putString("cvunigrade",id)         ;editor.commit(); }
    public String getunigrade()   { return  sharedPreferences.getString("cvunigrade","");  }

    public void setunistatus(String id) {                    editor.putString("cvunistatus",id)         ;editor.commit(); }
    public String getunistatus()   { return  sharedPreferences.getString("cvunistatus","0");  }



    //ms
        public void setmsdegreetitle(String id) {                    editor.putString("cvmt",id)         ;editor.commit(); }
    public String getmsdegreetitle()   { return  sharedPreferences.getString("cvmt","");  }

    public void setmsname(String id) {                    editor.putString("cvmsname",id)         ;editor.commit(); }
    public String getmsname()   { return  sharedPreferences.getString("cvmsname","");  }

    public void setmsstartyear(String id) {                    editor.putString("cvmsstartyear",id)         ;editor.commit(); }
    public String getmsstartyear()   { return  sharedPreferences.getString("cvmsstartyear","");  }

    public void setmsendyear(String id) {                    editor.putString("cvmsendyear",id)         ;editor.commit(); }
    public String getmsendyear()   { return  sharedPreferences.getString("cvmsendyear","");  }

    public void setmsgrade(String id) {                    editor.putString("cvmsgrade",id)         ;editor.commit(); }
    public String getmsgrade()   { return  sharedPreferences.getString("cvmsgrade","");  }



    public void setmsstatus(String id) {                    editor.putString("cvmsstatus",id)         ;editor.commit(); }
    public String getmsstatus()   { return  sharedPreferences.getString("cvmsstatus","0");  }


}
