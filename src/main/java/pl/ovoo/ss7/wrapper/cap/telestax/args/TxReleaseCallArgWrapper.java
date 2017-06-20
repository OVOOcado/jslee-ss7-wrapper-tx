/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.isup.message.parameter.CauseIndicators;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CauseWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ReleaseCallArgWrapper;

/**
 * TxReleaseCallArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxReleaseCallArgWrapper implements ReleaseCallArgWrapper {

    private transient CauseWrapper initialCallSegment = null;

    private CauseIndicators txCauseIndicators;

    public TxReleaseCallArgWrapper() {
    }

    @Override
    public void setInitialCallSegment(final CauseWrapper cause) throws Ss7WrapperException {
        if (cause != null) {
            final TxCauseWrapper txCauseWrapper = (TxCauseWrapper) cause;
            this.txCauseIndicators = txCauseWrapper.getTxCause();
            this.initialCallSegment = txCauseWrapper;
        } else {
            this.txCauseIndicators = null;
            this.initialCallSegment = null;
        }
    }

    @Override
    public CauseWrapper getInitialCallSegment() throws Ss7WrapperException {
        if (this.initialCallSegment == null && this.txCauseIndicators != null) {
            this.initialCallSegment = new TxCauseWrapper(txCauseIndicators);
        }
        return this.initialCallSegment;
    }

    @Override
    public boolean isInitialCallSegmentChose() throws Ss7WrapperException {
        return txCauseIndicators != null;
    }

    public CauseIndicators getTxCauseIndicators() {
        return txCauseIndicators;
    }

    public void setTxCauseIndicators(final CauseIndicators txCauseIndicators) {
        this.txCauseIndicators = txCauseIndicators;
        this.initialCallSegment = null;
    }

    @Override
    public String toString() {
        return "TxReleaseCallArgWrapper [txCauseIndicators=" + txCauseIndicators + "]";
    }

}
