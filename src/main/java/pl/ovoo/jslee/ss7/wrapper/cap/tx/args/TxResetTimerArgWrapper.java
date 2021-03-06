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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import pl.ovoo.jslee.ss7.wrapper.cap.args.ResetTimerArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.TimerID;


/**
 * TxResetTimerArgWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxResetTimerArgWrapper implements ResetTimerArgWrapper {

    /** The tx timer id. */
    private org.mobicents.protocols.ss7.cap.api.primitives.TimerID txTimerID;
    
    /** The tx timer value. */
    private int txTimerValue;

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ResetTimerArgWrapper#setTimerID(pl.ovoo.jslee.ss7.wrapper.cap.args.TimerID)
     */
    @Override
    public void setTimerID(final TimerID timeID) {
        if (timeID == null) {
            txTimerID = null;
        } else {
            txTimerID = org.mobicents.protocols.ss7.cap.api.primitives.TimerID.getInstance(timeID.getValue());
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ResetTimerArgWrapper#setTimerValue(int)
     */
    @Override
    public void setTimerValue(final int timerValue) {
        txTimerValue = timerValue;
    }

    /**
     * Gets the tx timer id.
     *
     * @return the tx timer id
     */
    public org.mobicents.protocols.ss7.cap.api.primitives.TimerID getTxTimerID() {
        return txTimerID;
    }

    /**
     * Gets the tx timer value.
     *
     * @return the tx timer value
     */
    public int getTxTimerValue() {
        return txTimerValue;
    }

    /**
     * Sets the tx timer id.
     *
     * @param txTimerID the new tx timer id
     */
    public void setTxTimerID(final org.mobicents.protocols.ss7.cap.api.primitives.TimerID txTimerID) {
        this.txTimerID = txTimerID;
    }

    /**
     * Sets the tx timer value.
     *
     * @param txTimerValue the new tx timer value
     */
    public void setTxTimerValue(final int txTimerValue) {
        this.txTimerValue = txTimerValue;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxResetTimerArgWrapper [txTimerID=" + txTimerID + ", txTimerValue=" + txTimerValue + "]";
    }

}
