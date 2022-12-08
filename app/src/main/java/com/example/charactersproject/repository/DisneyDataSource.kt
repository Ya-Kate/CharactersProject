package com.example.charactersproject.repository

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.charactersproject.Data
import javax.inject.Inject

class DisneyDataSource @Inject constructor(
    private val repository: DisneyCharacherApiRepository
) : PagingSource<Int, Data>() {

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val key = params.key ?: 1
        val respons = repository.getChercherFact(key, params.loadSize)
        return LoadResult.Page(
            data = respons.body()?.data ?: arrayListOf(),
            prevKey = null,
            nextKey = key + 1
        )
    }
}