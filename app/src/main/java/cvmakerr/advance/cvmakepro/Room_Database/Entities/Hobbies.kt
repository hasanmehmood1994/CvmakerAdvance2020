package cvmakerr.advance.cvmakepro.Room_Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "hobbies_table")
data class Hobbies(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "hobbiename") val hobbiename: String?,

    )
