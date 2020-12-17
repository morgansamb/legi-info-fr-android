package com.example.legi_info

import com.example.data.Network
import com.example.data.api.NosDeputesService
import com.example.data.db.AppDatabase
import com.example.data.preference.PrefsStore
import com.example.data.preference.SharedPrefsStorage
import com.example.data.repository.deputy.DeputyRepository
import com.example.data.repository.deputy.DeputyRepositoryImpl
import com.example.data.repository.file.FileRepository
import com.example.data.repository.file.FileRepositoryImpl
import com.example.data.repository.organization.OrganizationRepository
import com.example.data.repository.organization.OrganizationRepositoryImpl
import com.example.data.source.deputy.LocalDeputyDataSource
import com.example.data.source.deputy.LocalDeputyDataSourceImpl
import com.example.data.source.deputy.RemoteDeputyDataSource
import com.example.data.source.deputy.RemoteDeputyDataSourceImpl
import com.example.data.source.file.LocalFileDataSource
import com.example.data.source.file.LocalFileDataSourceImpl
import com.example.data.source.file.RemoteFileDataSource
import com.example.data.source.file.RemoteFileDataSourceImpl
import com.example.data.source.organization.LocalOrganizationDataSource
import com.example.data.source.organization.LocalOrganizationDataSourceImpl
import com.example.data.source.organization.RemoteOrganizationDataSource
import com.example.data.source.organization.RemoteOrganizationDataSourceImpl
import com.example.domain.usecase.deputy.GetDeputiesUseCase
import com.example.domain.usecase.deputy.GetDeputyUseCase
import com.example.domain.usecase.deputy.SearchDeputyUseCase
import com.example.domain.usecase.file.GetMostRecentFileUseCase
import com.example.domain.usecase.organization.GetOrganizationsUseCase
import com.example.legi_info.ui.nationalassembly.deputy.detail.DeputyDetailViewModel
import com.example.legi_info.ui.nationalassembly.deputy.list.DeputyListViewModel
import com.example.legi_info.ui.nationalassembly.filelist.FileListViewModel
import com.example.legi_info.ui.nationalassembly.organizationlist.OrganizationListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    /** Room Database **/
    single {
        AppDatabase.buildDatabase(androidContext())
    }

    /** Retrofit Service **/
    single {
        Network("https://www.nosdeputes.fr/").createAPIService(NosDeputesService::class)
    }

    /** Shared Prefs **/
    single { SharedPrefsStorage(androidApplication()) as PrefsStore }

    /**
     * Data Sources
     */
    single { RemoteDeputyDataSourceImpl(get()) as RemoteDeputyDataSource }
    single { LocalDeputyDataSourceImpl(
        deputyDao = get<AppDatabase>().deputyDao(),
        deputyDetailDao = get<AppDatabase>().deputyDetailDao(),
        deputySynthesisDao = get<AppDatabase>().deputySynthesisDao()
    ) as LocalDeputyDataSource }
    single { RemoteOrganizationDataSourceImpl(get()) as RemoteOrganizationDataSource }
    single { LocalOrganizationDataSourceImpl(get<AppDatabase>().organizationDao()) as LocalOrganizationDataSource }
    single { RemoteFileDataSourceImpl(get()) as RemoteFileDataSource }
    single { LocalFileDataSourceImpl(get<AppDatabase>().fileDao()) as LocalFileDataSource }

    /**
     * Repositories
     */
    single { DeputyRepositoryImpl(
        get(),
        get()
    ) as DeputyRepository }

    single { OrganizationRepositoryImpl(
        get(),
        get()
    ) as OrganizationRepository }

    single { FileRepositoryImpl(get(), get()) as FileRepository }

    // Deputy ViewModel
    viewModel {
        DeputyListViewModel(get(), get())
    }

    viewModel {
        DeputyDetailViewModel(get())
    }

    // Organization ViewModel
    viewModel {
        OrganizationListViewModel(get())
    }

    // File ViewModel
    viewModel {
        FileListViewModel(get())
    }

    /**
     * Use Cases
     */
    single { GetDeputiesUseCase(get()) }
    single { GetDeputyUseCase(get(), get()) }
    single { SearchDeputyUseCase(get()) }
    single { GetOrganizationsUseCase(get()) }
    single { GetMostRecentFileUseCase(get()) }
}
