package cvmakerr.advance.cvmakepro.Room_Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "skills_table")
data class Skills(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "skillname") val skillname: String?,
    @ColumnInfo(name = "skillpercetage") val skillpercetage: String?,
    @ColumnInfo(name = "intpercetage") val intpercetage: Int?,

)


