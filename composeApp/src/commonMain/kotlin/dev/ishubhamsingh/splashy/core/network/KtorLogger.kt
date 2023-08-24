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
package dev.ishubhamsingh.splashy.core.network

import Splashy.composeApp.BuildConfig
import io.github.aakira.napier.Napier
import io.ktor.client.plugins.logging.Logger

/** Created by Shubham Singh on 05/08/23. */
class KtorLogger() : Logger {
  override fun log(message: String) {
    Napier.d(message)
  }
}