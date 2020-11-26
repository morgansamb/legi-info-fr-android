package com.example.domain.usecase.file

import com.example.data.repository.file.FileRepository
import com.example.domain.result.Result
import java.lang.Exception

class GetMostRecentFileUseCase(
    private val fileRepository: FileRepository
) {
    suspend operator fun invoke() = try {
        val files = fileRepository.getMostRecentFiles()
        Result.Success(files)
    } catch (e: Exception) {
        Result.Error(e)
    }
}
