package com.example.mypokemonapplication.data.repository

import com.example.mypokemonapplication.data.datasource.PokemonsDataSource
import com.example.mypokemonapplication.data.transformer.PokemonsToDomainTransformer
import com.example.mypokemonapplication.domain.repository.PokemonsRepository
import javax.inject.Inject
import com.example.mypokemonapplication.core.Result


class PokemonsRepositoryImpl @Inject constructor(
    private val dataSource: PokemonsDataSource,
    private val transformer: PokemonsToDomainTransformer
) : PokemonsRepository {

    override suspend fun fetchAllPokemons() = try {
        transformer.toDomain(jsonPokemons = dataSource.execute(param = Unit)).let { pokemons ->
            Result.Success(data = pokemons)
        }
    } catch (e: Exception) {
        Result.Failure()
    }
}