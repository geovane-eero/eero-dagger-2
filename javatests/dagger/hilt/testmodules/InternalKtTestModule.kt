/*
 * Copyright (C) 2021 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dagger.hilt.testmodules

import dagger.ModuleDagger2
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Module for [dagger.hilt.android.InternalKtModuleTest]. */
@ModuleDagger2
@InstallIn(SingletonComponent::class)
internal abstract class InternalKtTestModule private constructor() {
  companion object {
    @Provides
    @Singleton
    fun provideString(): String = "expected_string_value"
  }
}

@ModuleDagger2
@InstallIn(SingletonComponent::class)
internal object InternalKtObjectModule {
  @Provides
  fun provideString(): Int = 9
}
