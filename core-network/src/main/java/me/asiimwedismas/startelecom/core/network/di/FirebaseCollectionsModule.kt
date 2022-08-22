package me.asiimwedismas.startelecom.core.network.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.asiimwedismas.startelecom.core.common.BuildConfig
import me.asiimwedismas.startelecom.core.model.VarConstants
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseCollectionsModule {

    @Provides
    @Singleton
    @Named("databaseCollection")
    fun provideDatabaseCollection(): CollectionReference =
        Firebase.firestore.collection(BuildConfig.BASE_DATABASE)

    @Provides
    @Singleton
    @DayExpenditureCollection
    fun provideDayExpenditureCollection(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES).collection(VarConstants.EXPENDITURES)


    @Provides
    @Singleton
    @CatalogueCollection
    fun provideCatalogueCollection(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES).collection(VarConstants.PRODUCT_CATALOGUE)

    @Provides
    @Singleton
    @MobileMoneyCollections
    fun provideMobileMoneyCollections(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES).collection(VarConstants.MOBILE_MONEY)

    @Provides
    @Singleton
    @IncompleteRepairsCollection
    fun provideIncompleteRepairsCollection(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES).collection(VarConstants.INCOMPLETE_REPAIRS)

    @Provides
    @Singleton
    @CompleteRepairsCollection
    fun provideCompleteRepairsCollection(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES)
        .collection(VarConstants.PAID_REPAIR_COMMISSIONS)

    @Provides
    @Singleton
    @BulkRepairsCollections
    fun provideBulkRepairsCollections(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES).collection(VarConstants.BULK_REPAIRS_SHEETS)

    @Provides
    @Singleton
    @PartialSalesCollection
    fun providePartialSalesCollection(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES).collection(VarConstants.PARTIAL_PAID_SALES)

    @Provides
    @Singleton
    @DebtCollection
    fun provideDebtCollection(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES).collection(VarConstants.DEBT_COLLECTIONS)

    @Provides
    @Singleton
    @CompleteSalesCollection
    fun provideCompleteSalesCollection(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES).collection(VarConstants.COMPLETE_PAID_SALES)

    @Provides
    @Singleton
    @StaffCollection
    fun provideStaffCollection(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES).collection(VarConstants.HR)

    @Provides
    @Singleton
    @StockCollection
    fun provideStockCollection(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES).collection(VarConstants.STOCk)

    @Provides
    @Singleton
    @StockRecordsCollection
    fun provideStockRecordsCollection(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES).collection(VarConstants.STOCK_RECORDS)

    @Provides
    @Singleton
    @DeletedStockCollection
    fun provideDeletedStockCollection(
        @Named("databaseCollection") baseDB: CollectionReference
    ) = baseDB.document(VarConstants.SHOP_ACTIVITIES).collection(VarConstants.DELETED_STOCK_RECORDS)

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IncompleteRepairsCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CompleteRepairsCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BulkRepairsCollections

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class StockCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class StockRecordsCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DeletedStockCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class StaffCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PartialSalesCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DebtCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CompleteSalesCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MobileMoneyCollections

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DayExpenditureCollection

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CatalogueCollection