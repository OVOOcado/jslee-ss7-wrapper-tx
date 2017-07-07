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

package pl.ovoo.ss7.wrapper.cap.tx.args;

import pl.ovoo.ss7.wrapper.cap.args.ResetTimerArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.TimerID;

/**
 * TxResetTimerArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxResetTimerArgWrapper implements ResetTimerArgWrapper {

    private org.mobicents.protocols.ss7.cap.api.primitives.TimerID txTimerID;
    private int txTimerValue;

    @Override
    public void setTimerID(final TimerID timeID) {
        if (timeID == null) {
            txTimerID = null;
        } else {
            txTimerID = org.mobicents.protocols.ss7.cap.api.primitives.TimerID.getInstance(timeID.getValue());
        }
    }

    @Override
    public void setTimerValue(final int timerValue) {
        txTimerValue = timerValue;
    }

    public org.mobicents.protocols.ss7.cap.api.primitives.TimerID getTxTimerID() {
        return txTimerID;
    }

    public int getTxTimerValue() {
        return txTimerValue;
    }

    public void setTxTimerID(final org.mobicents.protocols.ss7.cap.api.primitives.TimerID txTimerID) {
        this.txTimerID = txTimerID;
    }

    public void setTxTimerValue(final int txTimerValue) {
        this.txTimerValue = txTimerValue;
    }

    @Override
    public String toString() {
        return "TxResetTimerArgWrapper [txTimerID=" + txTimerID + ", txTimerValue=" + txTimerValue + "]";
    }

}
