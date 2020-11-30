package cvmakerr.advance.cvmakepro.Room_Database.Dio

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Languages
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Projects


@Dao
interface  ProjectsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setProjects(  projects: Projects)
    @Query("SELECT * from projects_table ORDER BY id ASC")
    fun getProjects() : LiveData<List<Projects>>
    @Query("DELETE FROM projects_table")
    fun deleteAll()
    @Query("DELETE FROM projects_table WHERE id = :i")
    fun deletesingle(i: Int)
}