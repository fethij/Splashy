/*
 * Copyright 2023 Shubham Singh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.ishubhamsingh.splashy.core.utils

import com.eygraber.uri.Uri
import dev.ishubhamsingh.splashy.features.details.WallpaperScreenType

/** Created by Shubham Singh on 19/08/23. */
actual class FileUtils {
  actual suspend fun saveByteArrayToFile(
    fileName: String,
    data: ByteArray,
    shouldOpenFile: Boolean
  ) {}

  actual suspend fun openFile(uri: Uri?, fileName: String) {}

  actual suspend fun applyWallpaper(data: ByteArray, wallpaperScreenType: WallpaperScreenType) {}

  actual suspend fun shouldAskStorageRuntimePermission(): Boolean {
    return true
  }

  actual suspend fun showMessage(message: String) {}
}
