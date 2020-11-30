package cvmakerr.advance.cvmakepro.Room_Database.Dio

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Hobbies
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Languages

@Dao
interface  LanguagesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setLanguages( languages: Languages)
    @Query("SELECT * from languages_table ORDER BY id ASC")
    fun getLanguages() : LiveData<List<Languages>>
    @Query("DELETE FROM languages_table")
    fun deleteAll()
    @Query("DELETE FROM languages_table WHERE id = :i")
    fun deletesingle(i: Int)
}