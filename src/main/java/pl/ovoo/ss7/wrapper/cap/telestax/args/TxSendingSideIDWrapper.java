/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.primitives.SendingSideID;
import pl.ovoo.ss7.wrapper.cap.args.LegType;
import pl.ovoo.ss7.wrapper.cap.args.SendingSideIDWrapper;

/**
 * TxReceivingSideIDWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxSendingSideIDWrapper implements SendingSideIDWrapper {

    private final SendingSideID sendingSideID;

    public TxSendingSideIDWrapper(final SendingSideID sendingSideID) {
        this.sendingSideID = sendingSideID;
    }

    @Override
    public LegType getSendingSideID() {
        if (sendingSideID.getSendingSideID() != null) {
            return LegType.valueOf(sendingSideID.getSendingSideID().getCode());
        }
        return null;
    }

    public SendingSideID getTxSendingSideID() {
        return sendingSideID;
    }

    @Override
    public String toString() {
        return "TxSendingSideIDWrapper [sendingSideID=" + sendingSideID + "]";
    }

}
