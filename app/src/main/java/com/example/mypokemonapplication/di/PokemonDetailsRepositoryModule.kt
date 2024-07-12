package com.example.mypokemonapplication.di

import com.example.mypokemonapplication.data.datasource.PokemonDetailsDataSource
import com.example.mypokemonapplication.data.repository.PokemonDetailsRepositoryImpl
import com.example.mypokemonapplication.data.transformer.PokemonDetailsToDomainTransformer
import com.example.mypokemonapplication.domain.repository.PokemonDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class PokemonDetailsRepositoryModule {

    @Provides
    fun providePokemonDetailsRepository(
        pokemonDetailsDataSource: PokemonDetailsDataSource,
        pokemonDetailTransformer: PokemonDetailsToDomainTransformer
    ): PokemonDetailsRepository = PokemonDetailsRepositoryImpl(
        dataSource = pokemonDetailsDataSource,
        transformer = pokemonDetailTransformer
    )
}