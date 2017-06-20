/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import pl.ovoo.ss7.wrapper.cap.args.ReceivingSideIDWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2CallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxReceivingSideIDWrapper;

/**
 * TxCap2CallInformationReportArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2CallInformationReportArgWrapper extends TxCallInformationReportArgWrapper
        implements Cap2CallInformationReportArgWrapper {

    private transient ReceivingSideIDWrapper legID = null;

    private ReceivingSideID txLegID;

    @Override
    public void setLegID(final ReceivingSideIDWrapper legID) {
        if (legID == null) {
            this.txLegID = null;
            this.legID = null;
        } else {
            final TxReceivingSideIDWrapper txReceivingSideIDWrapper = (TxReceivingSideIDWrapper) legID;
            this.txLegID = txReceivingSideIDWrapper.getTxReceivingSideID();
            this.legID = txReceivingSideIDWrapper;
        }
    }

    public ReceivingSideIDWrapper getLegID() {
        if (this.legID == null && this.txLegID != null) {
            this.legID = new TxReceivingSideIDWrapper(txLegID);
        }
        return this.legID;
    }

    public ReceivingSideID getTxLegID() {
        return txLegID;
    }

    public void setTxLegID(final ReceivingSideID txLegID) {
        this.txLegID = txLegID;
        this.legID = null;
    }

    @Override
    public String toString() {
        return "TxCap2CallInformationReportArgWrapper [txLegID=" + txLegID + "]";
    }

}
