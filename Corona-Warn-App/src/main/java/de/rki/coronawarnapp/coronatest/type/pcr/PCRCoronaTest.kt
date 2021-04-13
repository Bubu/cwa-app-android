package de.rki.coronawarnapp.coronatest.type.pcr

import de.rki.coronawarnapp.coronatest.qrcode.CoronaTestGUID
import de.rki.coronawarnapp.coronatest.server.CoronaTestResult
import de.rki.coronawarnapp.coronatest.type.CoronaTest
import de.rki.coronawarnapp.coronatest.type.RegistrationToken
import org.joda.time.Instant

data class PCRCoronaTest(
    override val testGUID: CoronaTestGUID,
    override val registeredAt: Instant,
    override val registrationToken: RegistrationToken,
    override val isRefreshing: Boolean = false,
    override val isSubmitted: Boolean = false,
    override val isViewed: Boolean = false,
    override val isAdvancedConsentGiven: Boolean = false,
    override val isJournalEntryCreated: Boolean = false,
    override val isNotificationSent: Boolean = false,
    val testResult: CoronaTestResult,
) : CoronaTest {

    override val type: CoronaTest.Type = CoronaTest.Type.PCR

    override val isSubmissionAllowed: Boolean = testResult == CoronaTestResult.PCR_POSITIVE

    val state: State
        get() = TODO()

    enum class State {
        PENDING,
        INVALID,
        POSITIVE,
        NEGATIVE,
        REDEEMED,
    }
}
