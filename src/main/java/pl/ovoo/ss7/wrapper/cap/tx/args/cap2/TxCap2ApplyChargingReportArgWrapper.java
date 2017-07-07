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
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2ApplyChargingReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2TimeDurationChargingResultWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxApplyChargingReportArgWrapper;

/**
 * TxCap2ApplyChargingReportArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2ApplyChargingReportArgWrapper extends TxApplyChargingReportArgWrapper
        implements Cap2ApplyChargingReportArgWrapper {

    private transient Cap2TimeDurationChargingResultWrapper timeDurationChargingResultWrapper = null;

    private TimeDurationChargingResult timeDurationChargingResult;

    @Override
    public boolean isTimeDurationChargingResultChosen() {
        return timeDurationChargingResult != null;
    }

    @Override
    public Cap2TimeDurationChargingResultWrapper getTimeDurationChargingResult() {
        if (this.timeDurationChargingResultWrapper == null && this.timeDurationChargingResult != null) {
            this.timeDurationChargingResultWrapper = new TxCap2TimeDurationChargingResultWrapper(
                    timeDurationChargingResult);
        }
        return this.timeDurationChargingResultWrapper;
    }

    @Override
    public void setTimeDurationChargingResult(final Cap2TimeDurationChargingResultWrapper timeDurationChargingResult) {
        if (timeDurationChargingResult == null) {
            this.timeDurationChargingResult = null;
            this.timeDurationChargingResultWrapper = null;
        } else {
            final TxCap2TimeDurationChargingResultWrapper txCap2TimeDurationChargingResultWrapper = (TxCap2TimeDurationChargingResultWrapper) timeDurationChargingResult;
            this.timeDurationChargingResult = txCap2TimeDurationChargingResultWrapper.getTxTimeDurationChargingResult();
            this.timeDurationChargingResultWrapper = txCap2TimeDurationChargingResultWrapper;
        }
    }

    public void setTxTimeDurationChargingResult(final TimeDurationChargingResult timeDurationChargingResult) {
        this.timeDurationChargingResult = timeDurationChargingResult;
        this.timeDurationChargingResultWrapper = null;
    }

    public TimeDurationChargingResult getTxTimeDurationChargingResult() {
        return timeDurationChargingResult;
    }

    @Override
    public String toString() {
        return "TxCap2ApplyChargingReportArgWrapper [timeDurationChargingResult=" + timeDurationChargingResult + "]";
    }
    
}
