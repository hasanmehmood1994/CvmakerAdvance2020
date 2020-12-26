package cvmakerr.advance.cvmakepro.Room_Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")
data class History(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "imgarray",typeAffinity = ColumnInfo.BLOB) val imagery:ByteArray?,
    )
