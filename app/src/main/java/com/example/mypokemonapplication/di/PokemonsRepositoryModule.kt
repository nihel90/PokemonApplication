package com.example.mypokemonapplication.di

import com.example.mypokemonapplication.data.datasource.PokemonsDataSource
import com.example.mypokemonapplication.data.repository.PokemonsRepositoryImpl
import com.example.mypokemonapplication.data.transformer.PokemonsToDomainTransformer
import com.example.mypokemonapplication.domain.repository.PokemonsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class PokemonsRepositoryModule {

    @Provides
    fun providePokemonsRepository(
        pokemonsDataSource: PokemonsDataSource,
        transformer: PokemonsToDomainTransformer
    ): PokemonsRepository = PokemonsRepositoryImpl(
        dataSource = pokemonsDataSource,
        transformer = transformer
    )
}