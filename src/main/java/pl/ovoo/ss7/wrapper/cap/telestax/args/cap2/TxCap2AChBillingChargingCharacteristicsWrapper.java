/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.CAMELAChBillingChargingCharacteristics;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2ReleaseIfDurationExceededWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxAChBillingChargingCharacteristicsWrapper;

/**
 * OcCap2AChBillingChargingCharacteristicsWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2AChBillingChargingCharacteristicsWrapper extends TxAChBillingChargingCharacteristicsWrapper implements Cap2AChBillingChargingCharacteristicsWrapper {

    public TxCap2AChBillingChargingCharacteristicsWrapper(final CAMELAChBillingChargingCharacteristics achBillingChargingCharacteristics) {
        super(achBillingChargingCharacteristics);
    }

    @Override
    public Cap2TimeDurationChargingWrapper getTimeDurationCharging() {
        final CAMELAChBillingChargingCharacteristics camelaChBillingChargingCharacteristics = getTxAchBillingChargingCharacteristics();
        final Cap2ReleaseIfDurationExceededWrapper cap2ReleaseIfDurationExceededWrapper;
        if (camelaChBillingChargingCharacteristics.getReleaseIfdurationExceeded()) {
            cap2ReleaseIfDurationExceededWrapper = new TxCap2ReleaseIfDurationExceededWrapper(camelaChBillingChargingCharacteristics.getAudibleIndicator());
        } else {
            cap2ReleaseIfDurationExceededWrapper = null;
        }
        return new TxCap2TimeDurationChargingWrapper(camelaChBillingChargingCharacteristics.getMaxCallPeriodDuration(),
                camelaChBillingChargingCharacteristics.getTariffSwitchInterval(), cap2ReleaseIfDurationExceededWrapper);
    }

    public static class TxCap2TimeDurationChargingWrapper implements Cap2TimeDurationChargingWrapper {

        private final long maxCallPeriodDuration;
        private final Long tariffSwitchInterval;
        private final Cap2ReleaseIfDurationExceededWrapper cap2ReleaseIfDurationExceededWrapper;

        public TxCap2TimeDurationChargingWrapper(final long maxCallPeriodDuration, final Long tariffSwitchInterval, final Cap2ReleaseIfDurationExceededWrapper cap2ReleaseIfDurationExceededWrapper) {
            this.maxCallPeriodDuration = maxCallPeriodDuration;
            this.tariffSwitchInterval = tariffSwitchInterval;
            this.cap2ReleaseIfDurationExceededWrapper = cap2ReleaseIfDurationExceededWrapper;
        }


        @Override
        public long getMaxCallPeriodDuration() {
            return maxCallPeriodDuration;
        }

        @Override
        public Cap2ReleaseIfDurationExceededWrapper getReleaseIfDurationExceeded() {
            return cap2ReleaseIfDurationExceededWrapper;
        }

        @Override
        public Long getTariffSwitchInterval() {
            return tariffSwitchInterval;
        }
    }
    

}
