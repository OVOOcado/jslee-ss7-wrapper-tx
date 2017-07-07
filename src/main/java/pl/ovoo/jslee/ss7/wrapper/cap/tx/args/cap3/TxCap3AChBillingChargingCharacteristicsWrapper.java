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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap3;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.CAMELAChBillingChargingCharacteristics;
import pl.ovoo.ss7.wrapper.cap.args.cap3.Cap3AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap3.Cap3ReleaseIfDurationExceededWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2AChBillingChargingCharacteristicsWrapper;

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
