/*
 * Copyright (C) 2016 The Dagger Authors.
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

package dagger.functional.producers.badexecutor;

import com.google.common.util.concurrent.MoreExecutors;
import dagger.ModuleDagger2;
import dagger.Provides;
import dagger.producers.Production;
import java.util.concurrent.Executor;

/**
 * A module that provides an optionally user-defined executor for a production component, defaulting
 * to the direct executor.
 */
@ModuleDagger2
public final class ExecutorModule {
  private final Executor executor;

  public ExecutorModule() {
    this(MoreExecutors.directExecutor());
  }

  public ExecutorModule(Executor executor) {
    this.executor = executor;
  }

  @Provides
  @Production
  Executor executor() {
    return executor;
  }
}
