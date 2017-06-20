/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2;

import org.mobicents.protocols.ss7.cap.api.primitives.SendingSideID;
import pl.ovoo.ss7.wrapper.cap.args.SendingSideIDWrapper;
import pl.ovoo.ss7.wrapper.cap.args.cap2.Cap2CallInformationRequestArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCallInformationRequestArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxSendingSideIDWrapper;

/**
 * TxCap2CallInformationRequestArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxCap2CallInformationRequestArgWrapper extends TxCallInformationRequestArgWrapper
        implements Cap2CallInformationRequestArgWrapper {

    private transient SendingSideIDWrapper legID = null;

    private SendingSideID txLegID;

    @Override
    public void setLegID(final SendingSideIDWrapper sendingSideID) {
        if (sendingSideID == null) {
            this.txLegID = null;
            this.legID = null;
        } else {
            final TxSendingSideIDWrapper txSendingSideIDWrapper = (TxSendingSideIDWrapper) sendingSideID;
            this.txLegID = txSendingSideIDWrapper.getTxSendingSideID();
            this.legID = txSendingSideIDWrapper;
        }

    }

    @Override
    public SendingSideIDWrapper getLegID() {
        if (this.legID == null && txLegID != null) {
            this.legID = new TxSendingSideIDWrapper(txLegID);
        }
        return this.legID;
    }

    public SendingSideID getTxLegID() {
        return txLegID;
    }

    public void setTxLegID(final SendingSideID txLegID) {
        this.txLegID = txLegID;
        this.legID = null;
    }

    @Override
    public String toString() {
        return "TxCap2CallInformationRequestArgWrapper [txLegID=" + txLegID + "]";
    }

}
