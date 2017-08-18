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

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.TimeDurationChargingResult;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2TimeDurationChargingResultWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2TimeInformationWrapper;


/**
 * OcCap2TimeDurationChargingResultWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2TimeDurationChargingResultWrapper implements Cap2TimeDurationChargingResultWrapper {

    /** The time duration charging result. */
    private transient Cap2TimeInformationWrapper timeDurationChargingResult = null;

    /** The tx time duration charging result. */
    private final TimeDurationChargingResult txTimeDurationChargingResult;

    /**
     * Instantiates a new tx cap2 time duration charging result wrapper.
     *
     * @param timeDurationChargingResult the time duration charging result
     */
    public TxCap2TimeDurationChargingResultWrapper(final TimeDurationChargingResult timeDurationChargingResult) {
        this.txTimeDurationChargingResult = timeDurationChargingResult;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2TimeDurationChargingResultWrapper#hasTimeInformation()
     */
    @Override
    public boolean hasTimeInformation() {
        return txTimeDurationChargingResult.getTimeInformation() != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2TimeDurationChargingResultWrapper#getTimeInformation()
     */
    @Override
    public Cap2TimeInformationWrapper getTimeInformation() {
        if (this.timeDurationChargingResult == null && hasTimeInformation()) {
            this.timeDurationChargingResult = new TxCap2TimeInformationWrapper(
                    txTimeDurationChargingResult.getTimeInformation());
        }
        return this.timeDurationChargingResult;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.cap2.Cap2TimeDurationChargingResultWrapper#getCallActive()
     */
    @Override
    public boolean getCallActive() {
        return txTimeDurationChargingResult.getLegActive();
    }

    /**
     * Gets the tx time duration charging result.
     *
     * @return the tx time duration charging result
     */
    public TimeDurationChargingResult getTxTimeDurationChargingResult() {
        return txTimeDurationChargingResult;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxCap2TimeDurationChargingResultWrapper [txTimeDurationChargingResult=" + txTimeDurationChargingResult
                + "]";
    }

}
