/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

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
