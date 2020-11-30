package cvmakerr.advance.cvmakepro.Room_Database.Dio

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Experience
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Qualification

@Dao
interface ExperienceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setExperience(experience: Experience)
    @Query("SELECT * from experience_table ORDER BY id ASC")
    fun getExperience() : LiveData<List<Experience>>
    @Query("DELETE FROM experience_table")
    fun deleteAll()
    @Query("DELETE FROM experience_table WHERE id = :i")
    fun deletesingle(i: Int)
}


