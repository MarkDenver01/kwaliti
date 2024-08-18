package app.io.kwaliti.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.io.kwaliti.utils.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class DeviceInformation(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val deviceType: String,
    val description: String,
    val deviceTypeByColor: DeviceColorType
)
