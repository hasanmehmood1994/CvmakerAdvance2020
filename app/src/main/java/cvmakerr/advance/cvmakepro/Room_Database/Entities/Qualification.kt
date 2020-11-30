package cvmakerr.advance.cvmakepro.Room_Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "qualification_table")
data class Qualification(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "degreename") val degreename: String?,
    @ColumnInfo(name = "institute") val institute: String?,
    @ColumnInfo(name = "startdate") val startdate: String?,
    @ColumnInfo(name = "startend") val endtdate: String?,
    @ColumnInfo(name = "date") val date: String?,

)


