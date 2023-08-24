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
package dev.ishubhamsingh.splashy

import Splashy.composeApp.BuildConfig
import android.app.Application
import dev.ishubhamsingh.splashy.core.di.appModule
import dev.ishubhamsingh.splashy.core.utils.initialiseLogging
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SplashyApp : Application() {
  companion object {
    lateinit var INSTANCE: SplashyApp
  }

  override fun onCreate() {
    super.onCreate()
    INSTANCE = this
    startKoin {
      androidContext(INSTANCE)
      androidLogger()
      modules(appModule())
    }
    if(BuildConfig.IS_DEBUG) {
      initialiseLogging()
    }
  }
}
