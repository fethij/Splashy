package dev.ishubhamsingh.splashy.core.utils

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

fun initialiseLogging() {
    Napier.base(DebugAntilog())
}