package app.io.kwaliti.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.io.kwaliti.utils.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class DeviceInformation(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val serialNumber: String,
    val deviceAddress: String,
    val deviceType: String,
    val deviceTypeByColor: DeviceColorType
)
