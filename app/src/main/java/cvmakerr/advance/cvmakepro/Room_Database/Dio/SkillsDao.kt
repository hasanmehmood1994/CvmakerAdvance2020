package cvmakerr.advance.cvmakepro.Room_Database.Dio

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Qualification
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Skills


@Dao
interface SkillsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setSkills(skills: Skills)
    @Query("SELECT * from skills_table ORDER BY id ASC")
    fun getSkills() : LiveData<List<Skills>>
    @Query("DELETE FROM skills_table")
    fun deleteAll()
    @Query("DELETE FROM skills_table WHERE id = :i")
    fun deletesingle(i: Int)
}