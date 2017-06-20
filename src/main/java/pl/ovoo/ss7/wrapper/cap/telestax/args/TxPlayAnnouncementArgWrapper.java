/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InformationToSend;
import pl.ovoo.ss7.wrapper.cap.args.InformationToSendWrapper;
import pl.ovoo.ss7.wrapper.cap.args.PlayAnnouncementArgWrapper;

/**
 * TxPlayAnnouncementArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxPlayAnnouncementArgWrapper implements PlayAnnouncementArgWrapper {

    private transient InformationToSendWrapper informationToSend = null;

    private Boolean txRequestAnnouncementComplete;
    private InformationToSend txInformationToSend;

    @Override
    public void setRequestAnnouncementComplete(final Boolean value) {
        txRequestAnnouncementComplete = value;
    }

    @Override
    public void setInformationToSend(final InformationToSendWrapper informationToSend) {
        if (informationToSend == null) {
            this.txInformationToSend = null;
            this.informationToSend = null;
        } else {
            final TxInformationToSendWrapper txInformationToSendWrapper = (TxInformationToSendWrapper) informationToSend;
            this.txInformationToSend = txInformationToSendWrapper.getTxInformationToSend();
            this.informationToSend = txInformationToSendWrapper;
        }
    }

    public InformationToSendWrapper getInformationToSendWrapper() {
        if (this.informationToSend == null && this.txInformationToSend != null) {
            this.informationToSend = new TxInformationToSendWrapper(txInformationToSend);
        }
        return this.informationToSend;
    }

    public InformationToSend getTxInformationToSend() {
        return txInformationToSend;
    }

    public void setTxInformationToSend(final InformationToSend txInformationToSend) {
        this.txInformationToSend = txInformationToSend;
        this.informationToSend = null;
    }

    public Boolean getTxRequestAnnouncementComplete() {
        return txRequestAnnouncementComplete;
    }

    public void setTxRequestAnnouncementComplete(final Boolean txRequestAnnouncementComplete) {
        this.txRequestAnnouncementComplete = txRequestAnnouncementComplete;
        
    }

    @Override
    public String toString() {
        return "TxPlayAnnouncementArgWrapper [informationToSendWrapper=" + informationToSend
                + ", txRequestAnnouncementComplete=" + txRequestAnnouncementComplete + ", txInformationToSend="
                + txInformationToSend + "]";
    }

}
