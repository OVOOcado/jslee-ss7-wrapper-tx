/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap3;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.CAMELAChBillingChargingCharacteristics;
import pl.ovoo.ss7.wrapper.cap.args.cap3.Cap3AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap3.Cap3ReleaseIfDurationExceededWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2AChBillingChargingCharacteristicsWrapper;

/**
 * TxCap3AChBillingChargingCharacteristicsWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap3AChBillingChargingCharacteristicsWrapper extends TxCap2AChBillingChargingCharacteristicsWrapper implements Cap3AChBillingChargingCharacteristicsWrapper {

    public TxCap3AChBillingChargingCharacteristicsWrapper(final CAMELAChBillingChargingCharacteristics achBillingChargingCharacteristics) {
        super(achBillingChargingCharacteristics);
    }

    public Cap3TimeDurationChargingWrapper getTimeDurationCharging() {
        final CAMELAChBillingChargingCharacteristics camelaChBillingChargingCharacteristics = getTxAchBillingChargingCharacteristics();
        final Cap3ReleaseIfDurationExceededWrapper cap2ReleaseIfDurationExceededWrapper;
        if (camelaChBillingChargingCharacteristics.getReleaseIfdurationExceeded()) {
            cap2ReleaseIfDurationExceededWrapper = new TxCap3ReleaseIfDurationExceededWrapper(camelaChBillingChargingCharacteristics.getAudibleIndicator());
        } else {
            cap2ReleaseIfDurationExceededWrapper = null;
        }
        return new TxCap3TimeDurationChargingWrapper(camelaChBillingChargingCharacteristics.getMaxCallPeriodDuration(),
                camelaChBillingChargingCharacteristics.getTariffSwitchInterval(), cap2ReleaseIfDurationExceededWrapper);
    }


    public static class TxCap3TimeDurationChargingWrapper extends TxCap2TimeDurationChargingWrapper implements Cap3AChBillingChargingCharacteristicsWrapper.Cap3TimeDurationChargingWrapper {


        public TxCap3TimeDurationChargingWrapper(final long maxCallPeriodDuration, final Long tariffSwitchInterval, final Cap3ReleaseIfDurationExceededWrapper cap2ReleaseIfDurationExceededWrapper) {
            super(maxCallPeriodDuration, tariffSwitchInterval, cap2ReleaseIfDurationExceededWrapper);
        }

        public Cap3ReleaseIfDurationExceededWrapper getReleaseIfDurationExceeded() {
            return (TxCap3ReleaseIfDurationExceededWrapper) super.getReleaseIfDurationExceeded();
        }
    }

}
