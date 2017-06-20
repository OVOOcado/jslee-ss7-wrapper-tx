/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.CAPDialog;
import org.mobicents.protocols.ss7.sccp.parameter.SccpAddress;
import pl.ovoo.ss7.wrapper.cap.args.DialogOpenArgWrapper;
import pl.ovoo.ss7.wrapper.common.args.SccpAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxSccpAddressWrapperImpl;

/**
 * TxDialogOpenArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxDialogOpenArgWrapper implements DialogOpenArgWrapper {

    private SccpAddressWrapper localSccpAddressWrapper = null;
    private SccpAddressWrapper remoteSccpAddressWrapper = null;

    private final SccpAddress localSccpAddress;
    private final SccpAddress remoteSccpAddress;

    public TxDialogOpenArgWrapper(final CAPDialog dialog) {
        localSccpAddress = dialog.getLocalAddress();
        remoteSccpAddress = dialog.getRemoteAddress();
    }

    @Override
    public SccpAddressWrapper getLocalSccpAddress() {
        if (this.localSccpAddressWrapper == null && this.localSccpAddress != null) {
            this.localSccpAddressWrapper = new TxSccpAddressWrapperImpl(localSccpAddress);
        }
        return this.localSccpAddressWrapper;
    }

    @Override
    public SccpAddressWrapper getRemoteSccpAddress() {
        if (this.remoteSccpAddressWrapper == null && this.remoteSccpAddress != null) {
            this.remoteSccpAddressWrapper = new TxSccpAddressWrapperImpl(remoteSccpAddress);
        }
        return this.remoteSccpAddressWrapper;
    }

    @Override
    public String toString() {
        return "TxDialogOpenArgWrapper [localSccpAddress=" + localSccpAddress + ", remoteSccpAddress="
                + remoteSccpAddress + "]";
    }

}
