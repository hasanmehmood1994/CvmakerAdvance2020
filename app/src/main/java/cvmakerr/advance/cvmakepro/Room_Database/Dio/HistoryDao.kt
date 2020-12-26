package cvmakerr.advance.cvmakepro.Room_Database.Dio

import androidx.lifecycle.LiveData
import androidx.room.*
import cvmakerr.advance.cvmakepro.Room_Database.Entities.History


@Dao
interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setHistory( history: History)

    @Query("SELECT * from history_table ORDER BY id ASC")
    fun getHistory() : LiveData<List<History>>

    @Query("DELETE FROM history_table")
    fun deleteAll()

    @Query("DELETE FROM history_table WHERE id = :i")
    fun deletesingle(i: Int)
}