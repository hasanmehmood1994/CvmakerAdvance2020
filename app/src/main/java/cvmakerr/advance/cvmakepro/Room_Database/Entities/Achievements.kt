package cvmakerr.advance.cvmakepro.Room_Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "achievements_table")
data class Achievements(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "organization") val organization: String?,
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "Description") val description: String?,
    @ColumnInfo(name = "start") val start: String?,
    @ColumnInfo(name = "end") val end: String?,
)

