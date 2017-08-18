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

import org.mobicents.protocols.ss7.isup.message.parameter.CauseIndicators;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.ReleaseCallArgWrapper;


/**
 * TxReleaseCallArgWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxReleaseCallArgWrapper implements ReleaseCallArgWrapper {

    /** The initial call segment. */
    private transient CauseWrapper initialCallSegment = null;

    /** The tx cause indicators. */
    private CauseIndicators txCauseIndicators;

    /**
     * Instantiates a new tx release call arg wrapper.
     */
    public TxReleaseCallArgWrapper() {
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ReleaseCallArgWrapper#setInitialCallSegment(pl.ovoo.jslee.ss7.wrapper.cap.args.CauseWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ReleaseCallArgWrapper#getInitialCallSegment()
     */
    @Override
    public CauseWrapper getInitialCallSegment() throws Ss7WrapperException {
        if (this.initialCallSegment == null && this.txCauseIndicators != null) {
            this.initialCallSegment = new TxCauseWrapper(txCauseIndicators);
        }
        return this.initialCallSegment;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.ReleaseCallArgWrapper#isInitialCallSegmentChose()
     */
    @Override
    public boolean isInitialCallSegmentChose() throws Ss7WrapperException {
        return txCauseIndicators != null;
    }

    /**
     * Gets the tx cause indicators.
     *
     * @return the tx cause indicators
     */
    public CauseIndicators getTxCauseIndicators() {
        return txCauseIndicators;
    }

    /**
     * Sets the tx cause indicators.
     *
     * @param txCauseIndicators the new tx cause indicators
     */
    public void setTxCauseIndicators(final CauseIndicators txCauseIndicators) {
        this.txCauseIndicators = txCauseIndicators;
        this.initialCallSegment = null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TxReleaseCallArgWrapper [txCauseIndicators=" + txCauseIndicators + "]";
    }

}
