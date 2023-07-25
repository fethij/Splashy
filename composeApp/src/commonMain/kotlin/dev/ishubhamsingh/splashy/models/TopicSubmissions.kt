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
package dev.ishubhamsingh.splashy.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopicSubmissions(
  @SerialName("architecture-interior") val architectureInterior: ArchitectureInterior? = null,
  @SerialName("experimental") val experimental: Experimental? = null,
  @SerialName("fashion-beauty") val fashionBeauty: FashionBeauty? = null,
  @SerialName("street-photography") val streetPhotography: StreetPhotography? = null,
  @SerialName("wallpapers") val wallpapers: Wallpapers? = null,
  @SerialName("travel") val travel: Travel? = null
)
