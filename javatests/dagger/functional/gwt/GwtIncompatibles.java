/*
 * Copyright (C) 2017 The Dagger Authors.
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

package dagger.functional.gwt;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import dagger.ModuleDagger2;
import dagger.Provides;
import java.lang.annotation.Retention;
import javax.inject.Inject;

interface GwtIncompatibles {
  @Retention(RUNTIME)
  @interface GwtIncompatible {}

  @GwtIncompatible
  class OnClass {
    @Inject
    OnClass() {}
  }

  class OnConstructor {
    @Inject
    @GwtIncompatible
    OnConstructor() {}
  }

  @GwtIncompatible
  class OuterClass {
    static class OnOuterClass {
      @Inject
      OnOuterClass() {}
    }
  }

  @GwtIncompatible
  class MembersInjectedType {
    @Inject String string;
  }

  @GwtIncompatible
  @ModuleDagger2
  class OnModule {
    @Provides
    static String onModule() {
      return "on module";
    }
  }

  @ModuleDagger2
  class OnMethod {
    @GwtIncompatible
    @Provides
    static String onMethod() {
      return "on method";
    }
  }
}
