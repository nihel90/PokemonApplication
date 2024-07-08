package com.example.mypokemonapplication.data.repository

import com.example.mypokemonapplication.core.Result
import com.example.mypokemonapplication.data.datasource.PokemonDetailsDataSource
import com.example.mypokemonapplication.data.transformer.PokemonDetailsToDomainTransformer
import com.example.mypokemonapplication.domain.repository.PokemonDetailsRepository
import javax.inject.Inject

class PokemonDetailsRepositoryImpl @Inject constructor(
    private val dataSource: PokemonDetailsDataSource,
    private val transformer: PokemonDetailsToDomainTransformer
) : PokemonDetailsRepository {

    override suspend fun fetchPokemonByName(name: String) = try {
        transformer.toDomain(jsonDetailsPokemons = dataSource.execute(param = name)).let { detailPokemon ->
            Result.Success(
                data = detailPokemon
            )
        }
    } catch (e: Exception) {
        Result.Failure()
    }
}