package com.sample.basearchpro.core.exception

import androidx.annotation.Keep
import com.sample.basearchpro.core.exception.Failure.FeatureFailure

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
@Keep
sealed class Failure {
    @Keep
    class NetworkConnection : Failure()

    @Keep
    class ServerError : Failure()

    @Keep
    class InternalError : Failure()

    @Keep
    class AcceptEulaError : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()

    /** * Extend this class for multiple feature specific failures.*/
    abstract class CompositeFeatureFailure : FeatureFailure() {
        abstract fun failures(): List<Failure>?
    }
}
