package com.jetpackcompose.getmeabeer.core.di

import com.jetpackcompose.getmeabeer.beerdetail.data.network.BeerDetailClient
import com.jetpackcompose.getmeabeer.beersearcher.data.network.BeerSearcherClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) //Scope/alcance a nivel de aplicación
class NetworkModule {
    @Singleton //Patrón singleton, para que sólo sea una sola instancia
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideSearcherBeersClient(retrofit: Retrofit): BeerSearcherClient {
        return retrofit.create(BeerSearcherClient::class.java)
    }
    @Singleton
    @Provides
    fun provideDetailBeerClient(retrofit: Retrofit): BeerDetailClient {
        return retrofit.create(BeerDetailClient::class.java)
    }
    companion object{
        private const val BASE_URL_API= "https://api.punkapi.com/v2/"
    }
}