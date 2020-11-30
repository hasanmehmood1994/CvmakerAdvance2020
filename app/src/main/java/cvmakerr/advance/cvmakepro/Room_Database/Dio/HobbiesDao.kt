package cvmakerr.advance.cvmakepro.Room_Database.Dio

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Hobbies
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Skills


@Dao
interface  HobbiesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setHobbies( hobbies: Hobbies)
    @Query("SELECT * from hobbies_table ORDER BY id ASC")
    fun getHobbies() : LiveData<List<Hobbies>>
    @Query("DELETE FROM hobbies_table")
    fun deleteAll()
    @Query("DELETE FROM hobbies_table WHERE id = :i")
    fun deletesingle(i: Int)
}