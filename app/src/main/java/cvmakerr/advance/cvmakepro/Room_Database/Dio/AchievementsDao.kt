package cvmakerr.advance.cvmakepro.Room_Database.Dio

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Achievements


@Dao
interface AchievementsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setAchivements(achievements: Achievements)
    @Query("SELECT * from achievements_table ORDER BY id ASC")
    fun getAchivements() : LiveData<List<Achievements>>
    @Query("DELETE FROM achievements_table")
    fun deleteAll()
    @Query("DELETE FROM achievements_table WHERE id = :i")
    fun deletesingle(i: Int)
}


