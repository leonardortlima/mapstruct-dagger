/*
 * Copyright 2021 Leonardo Lima
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
package io.leonardortlima;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

@Module
public interface BindsModule {

    @Binds
    @Named("io.leonardortlima.DecoratedSourceTargetMapperImpl_")
    DecoratedSourceTargetMapper decoratedSourceTargetMapper_(DecoratedSourceTargetMapperImpl_ impl);

    @Binds
    DecoratedSourceTargetMapper decoratedSourceTargetMapper(DecoratedSourceTargetMapperImpl impl);

    @Binds
    SourceTargetMapper sourceTargetMapper(SourceTargetMapperImpl impl);

    @Binds
    @Named("io.leonardortlima.SecondDecoratedSourceTargetMapperImpl_")
    SecondDecoratedSourceTargetMapper secondDecoratedSourceTargetMapper_(SecondDecoratedSourceTargetMapperImpl_ impl);

    @Binds
    SecondDecoratedSourceTargetMapper secondDecoratedSourceTargetMapper(SecondDecoratedSourceTargetMapperImpl impl);

}
