package cvmakerr.advance.cvmakepro.Room_Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "projects_table")
data class Projects(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "url") val url: String?,
    @ColumnInfo(name = "duration") val duration: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "start") val start: String?,
    @ColumnInfo(name = "end") val end: String?,
)

