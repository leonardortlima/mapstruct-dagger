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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class Dagger2BasedMapperTest {

    SourceTargetMapper mapper;

    DecoratedSourceTargetMapper decoratedMapper;

    SecondDecoratedSourceTargetMapper secondDecoratedMapper;

    @Before
    public void init() {
        AppComponent appComponent = DaggerAppComponent.create();
        mapper = appComponent.sourceTargetMapper();
        decoratedMapper = appComponent.decoratedSourceTargetMapper();
        secondDecoratedMapper = appComponent.secondDecoratedSourceTargetMapper();
    }

    @Test
    public void shouldInjectDagger2BasedMapper() {
        Source source = new Source();

        Target target = mapper.sourceToTarget( source );

        assertThat( target ).isNotNull();
        assertThat( target.getFoo() ).isEqualTo( Long.valueOf( 42 ) );
        assertThat( target.getDate() ).isEqualTo( "1980" );
    }

    @Test
    public void shouldInjectDecorator() {
        Source source = new Source();

        Target target = decoratedMapper.sourceToTarget( source );

        assertThat( target ).isNotNull();
        assertThat( target.getFoo() ).isEqualTo( Long.valueOf( 43 ) );
        assertThat( target.getDate() ).isEqualTo( "1980" );

        target = decoratedMapper.undecoratedSourceToTarget( source );

        assertThat( target ).isNotNull();
        assertThat( target.getFoo() ).isEqualTo( Long.valueOf( 42 ) );
        assertThat( target.getDate() ).isEqualTo( "1980" );
    }

    @Test
    public void shouldInjectSecondDecorator() {
        Source source = new Source();

        Target target = secondDecoratedMapper.sourceToTarget( source );

        assertThat( target ).isNotNull();
        assertThat( target.getFoo() ).isEqualTo( Long.valueOf( 43 ) );
        assertThat( target.getDate() ).isEqualTo( "1980" );

        target = secondDecoratedMapper.undecoratedSourceToTarget( source );

        assertThat( target ).isNotNull();
        assertThat( target.getFoo() ).isEqualTo( Long.valueOf( 42 ) );
        assertThat( target.getDate() ).isEqualTo( "1980" );
    }
}
