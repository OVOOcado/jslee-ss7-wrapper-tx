/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.CAMELAChBillingChargingCharacteristics;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxAChBillingChargingCharacteristicsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2ReleaseIfDurationExceededWrapper;


/**
 * OcCap2AChBillingChargingCharacteristicsWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2AChBillingChargingCharacteristicsWrapper extends TxAChBillingChargingCharacteristicsWrapper implements Cap2AChBillingChargingCharacteristicsWrapper {

    /**
     * Instantiates a new tx cap2 a ch billing charging characteristics wrapper.
     *
     * @param achBillingChargingCharacteristics the ach billing charging characteristics
     */
    public TxCap2AChBillingChargingCharacteristicsWrapper(final CAMELAChBillingChargingCharacteristics achBillingChargingCharacteristics) {
        super(achBillingChargingCharacteristics);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2AChBillingChargingCharacteristicsWrapper#getTimeDurationCharging()
     */
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

    /**
     * The Class TxCap2TimeDurationChargingWrapper.
     */
    public static class TxCap2TimeDurationChargingWrapper implements Cap2TimeDurationChargingWrapper {

        /** The max call period duration. */
        private final long maxCallPeriodDuration;
        
        /** The tariff switch interval. */
        private final Long tariffSwitchInterval;
        
        /** The cap2 release if duration exceeded wrapper. */
        private final Cap2ReleaseIfDurationExceededWrapper cap2ReleaseIfDurationExceededWrapper;

        /**
         * Instantiates a new tx cap2 time duration charging wrapper.
         *
         * @param maxCallPeriodDuration the max call period duration
         * @param tariffSwitchInterval the tariff switch interval
         * @param cap2ReleaseIfDurationExceededWrapper the cap2 release if duration exceeded wrapper
         */
        public TxCap2TimeDurationChargingWrapper(final long maxCallPeriodDuration, final Long tariffSwitchInterval, final Cap2ReleaseIfDurationExceededWrapper cap2ReleaseIfDurationExceededWrapper) {
            this.maxCallPeriodDuration = maxCallPeriodDuration;
            this.tariffSwitchInterval = tariffSwitchInterval;
            this.cap2ReleaseIfDurationExceededWrapper = cap2ReleaseIfDurationExceededWrapper;
        }


        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2AChBillingChargingCharacteristicsWrapper.Cap2TimeDurationChargingWrapper#getMaxCallPeriodDuration()
         */
        @Override
        public long getMaxCallPeriodDuration() {
            return maxCallPeriodDuration;
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2AChBillingChargingCharacteristicsWrapper.Cap2TimeDurationChargingWrapper#getReleaseIfDurationExceeded()
         */
        @Override
        public Cap2ReleaseIfDurationExceededWrapper getReleaseIfDurationExceeded() {
            return cap2ReleaseIfDurationExceededWrapper;
        }

        /* (non-Javadoc)
         * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2AChBillingChargingCharacteristicsWrapper.Cap2TimeDurationChargingWrapper#getTariffSwitchInterval()
         */
        @Override
        public Long getTariffSwitchInterval() {
            return tariffSwitchInterval;
        }
    }
    

}
