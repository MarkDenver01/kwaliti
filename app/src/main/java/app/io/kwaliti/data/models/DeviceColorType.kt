package app.io.kwaliti.data.models

import androidx.compose.ui.graphics.Color
import app.io.kwaliti.ui.theme.HubColor
import app.io.kwaliti.ui.theme.LockColor
import app.io.kwaliti.ui.theme.NoneColor
import app.io.kwaliti.ui.theme.RemoteColor

enum class DeviceColorType(val color: Color) {
    LOCK(LockColor),
    HUB(HubColor),
    REMOTE(RemoteColor),
    NONE(NoneColor)
}