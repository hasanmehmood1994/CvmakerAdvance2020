package cvmakerr.advance.cvmakepro.Room_Database.Dio

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Qualification

@Dao
interface QualificationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setQualification(qualification: Qualification)
    @Query("SELECT * from qualification_table ORDER BY id ASC")
    fun getQualification() : LiveData<List<Qualification>>
    @Query("DELETE FROM qualification_table")
    fun deleteAll()
    @Query("DELETE FROM qualification_table WHERE id = :i")
    fun deletesingle(i: Int)
}