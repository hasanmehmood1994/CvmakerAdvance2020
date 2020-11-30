package cvmakerr.advance.cvmakepro.Room_Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "experience_table")
data class Experience(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "companyname") val companyname: String?,
    @ColumnInfo(name = "designation") val designation: String?,
    @ColumnInfo(name = "duration") val duration: String?,
    @ColumnInfo(name = "Description") val description: String?,
    @ColumnInfo(name = "start") val start: String?,
    @ColumnInfo(name = "end") val end: String?,
)

