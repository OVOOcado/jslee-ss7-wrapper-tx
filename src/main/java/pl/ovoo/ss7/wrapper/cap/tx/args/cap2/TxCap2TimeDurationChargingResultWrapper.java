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

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.TimeDurationChargingResult;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2TimeDurationChargingResultWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2TimeInformationWrapper;

/**
 * OcCap2TimeDurationChargingResultWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2TimeDurationChargingResultWrapper implements Cap2TimeDurationChargingResultWrapper {

    private transient Cap2TimeInformationWrapper timeDurationChargingResult = null;

    private final TimeDurationChargingResult txTimeDurationChargingResult;

    public TxCap2TimeDurationChargingResultWrapper(final TimeDurationChargingResult timeDurationChargingResult) {
        this.txTimeDurationChargingResult = timeDurationChargingResult;
    }

    @Override
    public boolean hasTimeInformation() {
        return txTimeDurationChargingResult.getTimeInformation() != null;
    }

    @Override
    public Cap2TimeInformationWrapper getTimeInformation() {
        if (this.timeDurationChargingResult == null && hasTimeInformation()) {
            this.timeDurationChargingResult = new TxCap2TimeInformationWrapper(
                    txTimeDurationChargingResult.getTimeInformation());
        }
        return this.timeDurationChargingResult;
    }

    @Override
    public boolean getCallActive() {
        return txTimeDurationChargingResult.getLegActive();
    }

    public TimeDurationChargingResult getTxTimeDurationChargingResult() {
        return txTimeDurationChargingResult;
    }

    @Override
    public String toString() {
        return "TxCap2TimeDurationChargingResultWrapper [txTimeDurationChargingResult=" + txTimeDurationChargingResult
                + "]";
    }

}
