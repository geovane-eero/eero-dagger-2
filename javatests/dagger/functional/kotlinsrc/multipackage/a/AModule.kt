/*
 * Copyright (C) 2023 The Dagger Authors.
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

package dagger.functional.kotlinsrc.multipackage.a

import dagger.Binds
import dagger.ModuleDagger2
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey

@ModuleDagger2
abstract class AModule {
  @Binds
  @IntoSet
  internal abstract fun provideInaccessible(inaccessible: Inaccessible): Inaccessible

  @Binds
  @IntoMap
  @StringKey("inaccessible")
  internal abstract fun provideInaccessibleToMap(inaccessible: Inaccessible): Inaccessible

  companion object {
    @Provides
    @IntoSet fun provideString(): String = "a"

    @Provides
    @ElementsIntoSet
    internal fun provideSetOfInaccessibles(): Set<Inaccessible> = hashSetOf()
  }
}
