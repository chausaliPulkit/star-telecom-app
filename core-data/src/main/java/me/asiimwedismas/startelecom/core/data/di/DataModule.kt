/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.asiimwedismas.startelecom.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.asiimwedismas.startelecom.core.data.repository.StaffMemberRepository
import me.asiimwedismas.startelecom.core.data.repository.StaffMemberRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsStaffMemberRepository(
        topicsRepository: StaffMemberRepositoryImpl
    ): StaffMemberRepository

//    @Binds
//    fun bindsAuthorsRepository(
//        authorsRepository: OfflineFirstAuthorsRepository
//    ): AuthorsRepository
//
//    @Binds
//    fun bindsNewsResourceRepository(
//        newsRepository: OfflineFirstNewsRepository
//    ): NewsRepository
}
