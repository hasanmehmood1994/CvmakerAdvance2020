package cvmakerr.advance.cvmakepro.Room_Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "languages_table")
data class Languages(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "languagename") val languagename: String?,

    )


